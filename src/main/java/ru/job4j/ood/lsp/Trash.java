package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Trash implements Store {

    private List<Food> foodInTrash;

    public Trash(List<Food> foodInTrash) {
        this.foodInTrash = foodInTrash;
    }

    public List<Food> getFoodInTrash() {
        return foodInTrash;
    }

    public void setFoodInTrash(List<Food> foodInTrash) {
        this.foodInTrash = foodInTrash;
    }

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (test(food)) {
            foodInTrash.add(food);
            System.out.println("Продукт добавлен в мусорное ведро");
            result = true;
        }
        return result;
    }

    @Override
    public boolean test(Food food) {
        long expiryDays = Period.between(food.getCreateDate(), food.getExpiryDate()).getDays();
        long endDays = Period.between(food.getCreateDate(), LocalDate.now()).getDays();
        return endDays >= expiryDays;
    }
}
