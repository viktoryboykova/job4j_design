package ru.job4j.ood.isp;

import java.util.*;

public class SimpleMenu {

    private List<MenuItem> parents;


    public SimpleMenu(List<MenuItem> parents) {
        this.parents = parents;
    }

    public static void main(String[] args) {
        MenuItem item1111 = new MenuItem("---задача 1.1.1.1", new NotFound(), new ArrayList<>());
        MenuItem item111 = new MenuItem("--задача 1.1.1", new OpenClose(), List.of(item1111));
        MenuItem item121 = new MenuItem("--задача 1.2.1", new NotFound(), new ArrayList<>());
        MenuItem item11 = new MenuItem("-задача 1.1", new OpenClose(), List.of(item111));
        MenuItem item12 = new MenuItem("-задача 1.2", new OpenClose(), List.of(item121));
        MenuItem item1 = new MenuItem("задача 1", new OpenClose(), List.of(item11, item12));
        MenuItem item2 = new MenuItem("задача 2", new NotFound(), new ArrayList<>());
        MenuItem item3 = new MenuItem("задача 3", new NotFound(), new ArrayList<>());
        SimpleMenu simpleMenu = new SimpleMenu(List.of(item1, item2, item3));
        simpleMenu.start();
    }

    private void showMenu(List<MenuItem> list) {
        for (MenuItem item : list) {
            System.out.println(item.getName());
            if (item.isOpened()) {
                showMenu(item.getChildren());
            }
        }
    }

     private MenuItem find(List<MenuItem> list, String answer) {
        MenuItem menuItem = null;
         for (MenuItem item : list) {
             String[] names = item.getName().split(" ");
             if (names[1].equals(answer)) {
                 menuItem = item;
                 break;
             } else {
                 menuItem = find(item.getChildren(), answer);
                 if (menuItem != null) {
                     break;
                 }
             }
         }
         return menuItem;
     }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        showMenu(parents);
        String answer = scanner.nextLine();
        while (!answer.equals("СТОП")) {
            MenuItem item = find(parents, answer);
            if (item != null) {
                item.getActionMenu().action(item);
            } else {
                System.out.println("пункт не найден");
            }
            showMenu(parents);
            answer = scanner.nextLine();
        }
    }
}