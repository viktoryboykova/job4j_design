package ru.job4j.ood.lsp.parking;

public class Vehicle {

    private String name;
    private int size;

    public Vehicle(String name, int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Размер машины не может быть = 0");
        }
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Vehicle{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}
