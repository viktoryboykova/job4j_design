package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            for (int i = index; i < data.length; i++) {
                if (data[i] % 2 == 0) {
                    index = i + 1;
                    return data[i];
                }
            }
        }
        throw new NoSuchElementException();
    }
}
