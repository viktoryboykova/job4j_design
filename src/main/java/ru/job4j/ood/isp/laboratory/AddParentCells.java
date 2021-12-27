package ru.job4j.ood.isp.laboratory;

import java.util.Scanner;

public class AddParentCells implements Action {

    @Override
    public void action(Laboratory laboratory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество новых клеток:");
        String answer = scanner.nextLine();
        boolean notAdd = true;
        while (notAdd) {
            try {
                for (int i = 1; i <= Integer.parseInt(answer); i++) {
                    laboratory.getCells().add(new Cell(1));
                }
                notAdd = false;
                System.out.println("Клетки добавлены. Актуальное количество: " + laboratory.getCells().size());
            } catch (NumberFormatException e) {
                System.out.println("Введенный ответ - текст, а не число");
                answer = scanner.nextLine();
            }
        }
    }

    @Override
    public String getName() {
        return "Добавить новые родительские клетки";
    }
}
