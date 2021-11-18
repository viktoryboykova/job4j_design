package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    @SuppressWarnings("checkstyle:WhitespaceAround")
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                if (read != 13 && read != 10) {
                    text.append((char) read);
                } else if (read == 13) {
                    int num = Integer.parseInt(text.toString());
                    boolean rsl = num % 2 == 0;
                    System.out.println("число " + num + " четное : " + rsl);
                } else {
                    text = new StringBuilder();
                }
            }
            int num = Integer.parseInt(text.toString());
            boolean rsl = num % 2 == 0;
            System.out.println("число " + num + " четное : " + rsl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
