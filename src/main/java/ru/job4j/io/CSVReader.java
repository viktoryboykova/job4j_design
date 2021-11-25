package ru.job4j.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        if (argsName.get("path") == null || (!argsName.get("out").equals("stdout") && !argsName.get("out").endsWith("csv"))) {
            throw new IllegalArgumentException("Arguments are not correct.");
        }
        try (FileInputStream in = new FileInputStream(argsName.get("path"))) {
            Scanner scanner = new Scanner(in);
            String[] head = scanner.nextLine().split(argsName.get("delimiter"));
            String[] filter = argsName.get("filter").split(",");
            List<Integer> listOfIndex = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < head.length; i++) {
                for (String s : filter) {
                    if (head[i].equals(s)) {
                        listOfIndex.add(i);
                        stringBuilder.append(s).append(argsName.get("delimiter"));
                    }
                }
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            stringBuilder.append(System.lineSeparator());
            while (scanner.hasNext()) {
                String[] words = scanner.nextLine().split(argsName.get("delimiter"));
                for (Integer ofIndex : listOfIndex) {
                    stringBuilder.append(words[ofIndex]).append(argsName.get("delimiter"));
                }
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
                stringBuilder.append(System.lineSeparator());
            }
            try (FileOutputStream out = new FileOutputStream(argsName.get("out"))) {
                out.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        CSVReader.handle(argsName);
    }
}
