package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class Matrix {

    public static int[][] multiple(int size) {
        int[][] umn = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
              umn[i - 1][j - 1] = i * j;  
            }
        }
        return umn;
    }

    public static void main(String[] args) {
        int[][] in = Matrix.multiple(4);
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int[] abc : in) {
                out.write(Arrays.toString(abc).getBytes());
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
