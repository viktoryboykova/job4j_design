package ru.job4j.ood.isp.laboratory;

import java.util.List;

public class CellDivision implements Action {

    @Override
    public void action(Laboratory laboratory) {
        if (laboratory.getFood() >= 2) {
            int before = laboratory.getFood();
            goToCell(laboratory.getCells(), laboratory);
            int after = laboratory.getFood();
            System.out.println("Новых дочерних клеток: " + (before - after));
        } else {
            System.out.println("Недостаточно еды");
        }
    }

    private void goToCell(List<Cell> cells, Laboratory laboratory) {
        for (Cell cell : cells) {
            if (laboratory.getFood() >= 2) {
                if (cell.getChildren().isEmpty()) {
                    cell.setChildren(List.of(new Cell(cell.getGeneration() + 1), new Cell(cell.getGeneration() + 1)));
                    System.out.println("Добавлено новое поколение № " + (cell.getGeneration() + 1));
                    laboratory.setFood(laboratory.getFood() - 2);
                } else {
                    goToCell(cell.getChildren(), laboratory);
                }
            } else {
                break;
            }
        }
    }

    @Override
    public String getName() {
        return "Выполнить деление клеток";
    }
}
