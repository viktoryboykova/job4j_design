package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            List<String> list = new ArrayList<>();
            StringBuilder text = new StringBuilder();
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] word = line.split(" ");
                if (text.toString().isEmpty()) {
                    if (Objects.equals(word[0], "400") || Objects.equals(word[0], "500")) {
                        text.append(word[1]).append(";");
                    }
                } else {
                    if (!Objects.equals(word[0], "400") && !Objects.equals(word[0], "500")) {
                        text.append(word[1]).append(";");
                        list.add(text.toString());
                        text = new StringBuilder();
                    }
                }
            }
            list.forEach(out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            Analizy analizy = new Analizy();
            analizy.unavailable("server.log", "unavailable.csv");
    }
}
