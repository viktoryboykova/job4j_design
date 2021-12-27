package ru.job4j.ood.isp;

public class NotFound implements MenuAction {
    @Override
    public void action(MenuItem menuItem) {
        System.out.println("у " + menuItem.getName() + " не найдены подпункты");
    }
}
