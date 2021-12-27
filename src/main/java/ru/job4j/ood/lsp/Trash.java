package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
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
            System.out.println("Продукт " + food.getName() + " добавлен в мусорное ведро");
            result = true;
        }
        return result;
    }

    @Override
    public boolean test(Food food) {
        long expiryDays = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long endDays = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        return endDays >= expiryDays;
    }

    @Override
    public List<Food> getFood() {
        return foodInTrash;
    }
}
