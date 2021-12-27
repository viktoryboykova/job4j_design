package ru.job4j.ood.isp.laboratory;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int generation;
    private List<Cell> children = new ArrayList<>();

    public Cell(int generation) {
        this.generation = generation;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public List<Cell> getChildren() {
        return children;
    }

    public void setChildren(List<Cell> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Cell{"
                + "generation=" + generation
                + ", children=" + children.size()
                + '}';
    }
}
