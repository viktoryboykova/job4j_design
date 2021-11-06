package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        for (int i = row; i < data.length; i++) {
            for (int j = column; j < data[i].length; j++) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            for (int i = row; i < data.length; i++) {
                for (int j = column; j < data[i].length; j++) {
                    if (column < data[i].length - 1) {
                        column++;
                    } else {
                        row++;
                        column = 0;
                    }
                    return data[i][j];
                }
            }
        }
        throw new NoSuchElementException();
    }
}
