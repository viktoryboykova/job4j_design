package ru.job4j.ood.isp.laboratory;

import java.util.Scanner;

public class AddFood implements Action {

    @Override
    public void action(Laboratory laboratory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество еды:");
        String answer = scanner.nextLine();
        boolean notAdd = true;
        while (notAdd) {
            try {
                laboratory.setFood(Integer.parseInt(answer));
                notAdd = false;
                System.out.println("Еда добавлена. Актуальное количество: " + laboratory.getFood());
            } catch (NumberFormatException e) {
                System.out.println("Введенный ответ - текст, а не число");
                answer = scanner.nextLine();
            }
        }
    }

    @Override
    public String getName() {
        return "Добавить еду";
    }
}
