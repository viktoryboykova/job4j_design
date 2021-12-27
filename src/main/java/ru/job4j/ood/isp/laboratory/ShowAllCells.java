package ru.job4j.ood.isp.laboratory;

import java.util.List;

public class ShowAllCells implements Action {

    @Override
    public void action(Laboratory laboratory) {
        if (laboratory.getCells().size() == 0) {
            System.out.println("В лаборатории нет клеток");
        } else {
            for (Cell cell : laboratory.getCells()) {
                System.out.println("-" + cell);
                showChildren(cell.getChildren());
            }
        }
    }

    private void showChildren(List<Cell> children) {
        if (children.size() > 0) {
            for (Cell child : children) {
                System.out.println("-".repeat(child.getGeneration()) + child);
                showChildren(child.getChildren());
            }
        }
    }

    @Override
    public String getName() {
        return "Показать все клетки";
    }
}
