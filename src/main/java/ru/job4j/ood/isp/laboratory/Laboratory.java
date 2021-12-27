package ru.job4j.ood.isp.laboratory;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Laboratory {
    private int food;
    private List<Cell> cells = new ArrayList<>();
    private List<Action> actions;

    public Laboratory(List<Action> actions) {
        this.actions = actions;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public List<Action> getActions() {
        return actions;
    }

    public static void main(String[] args) {
        Action showAll = new ShowAllCells();
        Action addParent = new AddParentCells();
        Action deleteAll = new DeleteAllCells();
        Action leftoverFood = new LeftoverFood();
        Action addFood = new AddFood();
        Action division = new CellDivision();
        Laboratory laboratory = new Laboratory(List.of(showAll, addParent, deleteAll, leftoverFood, addFood, division));
        laboratory.start(laboratory);
    }

    private void start(Laboratory laboratory) {
        Scanner scanner = new Scanner(System.in);
        showMenu(actions);
        String answer = scanner.nextLine();
        while (!answer.equals("СТОП")) {
            if (find(answer)) {
                actions.get(Integer.parseInt(answer) - 1).action(laboratory);
            }
            showMenu(actions);
            answer = scanner.nextLine();
        }
    }

    private boolean find(String answer) {
        boolean result = false;
        try {
            if (Integer.parseInt(answer) > 0 && Integer.parseInt(answer) <= actions.size()) {
                result = true;
            } else {
                System.out.println("Пункт не найден, введите корректный пункт");
            }
        } catch (NumberFormatException e) {
            System.out.println("Введенный ответ - текст, а не число");
        }
        return result;
    }

    private void showMenu(List<Action> actions) {
        System.out.println("Доступные действия:");
        for (int i = 1; i <= actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i - 1).getName());
        }
    }
}
