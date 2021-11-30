package ru.job4j.io.find;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Finder {

    public static void main(String[] args) throws IOException {
        ArgsName argsNames = ArgsName.of(args);
        if (argsNames.get("d") == null || argsNames.get("n") == null || argsNames.get("t") == null || argsNames.get("o") == null) {
            throw new IllegalArgumentException("Отсутствует(-ют) необходимый(-е) аргумент(-ы)");
        }
        String mask;
        List<Path> list = new ArrayList<>();
        if (argsNames.get("t").equals("mask")) {
            if (argsNames.get("n").startsWith("*") && argsNames.get("n").endsWith("*")) {
                mask = argsNames.get("n").substring(1, argsNames.get("n").length() - 1);
                list = Search.search(Paths.get(argsNames.get("d")), path -> path.toFile().getName().contains(mask));
            } else if (argsNames.get("n").endsWith("*")) {
                mask = argsNames.get("n").substring(0, argsNames.get("n").length() - 1);
                list = Search.search(Paths.get(argsNames.get("d")), path -> path.toFile().getName().startsWith(mask));
            } else {
                mask = argsNames.get("n").substring(1);
                list = Search.search(Paths.get(argsNames.get("d")), path -> path.toFile().getName().endsWith(mask));
            }
        } else if (argsNames.get("t").equals("name")) {
            list = Search.search(Paths.get(argsNames.get("d")), path -> path.toFile().getName().equals(argsNames.get("n")));
        } else {
            list = Search.search(Paths.get(argsNames.get("d")), path -> Pattern.matches(argsNames.get("n"), path.toFile().getName()));
        }
        writeToFile(list, new File(argsNames.get("o")));
    }

    public static void writeToFile(List<Path> sources, File target) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            for (Path source : sources) {
                out.write(source.toFile().getName() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
