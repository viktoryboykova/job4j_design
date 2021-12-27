package ru.job4j.ood.isp.laboratory;

public class DeleteAllCells implements Action {

    @Override
    public void action(Laboratory laboratory) {
        laboratory.getCells().clear();
        System.out.println("Все клетки удалены!");
    }

    @Override
    public String getName() {
        return "Убить все клетки";
    }
}
