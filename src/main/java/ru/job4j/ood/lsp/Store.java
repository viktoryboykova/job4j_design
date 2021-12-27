package ru.job4j.ood.lsp;

import java.util.List;

public interface Store {

    boolean add(Food food);
    boolean test(Food food);
    List<Food> getFood();
}
