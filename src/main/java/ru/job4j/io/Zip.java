package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                out.putNextEntry(new ZipEntry(source.toString()));
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    out.write(in.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName arg = ArgsName.of(args);
        if (arg.get("d") == null || arg.get("o") == null) {
            throw new IllegalArgumentException("Отсутствует(-ют) необходимый(-е) аргумент(-ы)");
        }
        File file = new File(arg.get("d"));
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        List<Path> list = Search.search(file.toPath(), arg.get("e") == null ? path -> true : path -> !path.toFile().getName().endsWith(arg.get("e")));
        packFiles(list, new File(arg.get("o")));
    }
}
