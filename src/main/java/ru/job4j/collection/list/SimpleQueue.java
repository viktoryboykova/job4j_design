package ru.job4j.collection.list;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int sizeIn = 0;

    public T poll() {
        int sizeOut = 0;
        while (sizeIn > 0) {
            out.push(in.pop());
            sizeIn--;
            sizeOut++;
        }
        T value = out.pop();
        sizeOut--;
        while (sizeOut > 0) {
            push(out.pop());
            sizeOut--;
        }
        return value;
    }

    public void push(T value) {
        in.push(value);
        sizeIn++;
    }
}
