package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Warehouse implements Store {

    private List<Food> foodInWarehouse;

    public Warehouse(List<Food> foodInWarehouse) {
        this.foodInWarehouse = foodInWarehouse;
    }

    public List<Food> getFoodInWarehouse() {
        return foodInWarehouse;
    }

    public void setFoodInWarehouse(List<Food> foodInWarehouse) {
        this.foodInWarehouse = foodInWarehouse;
    }

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (test(food)) {
            foodInWarehouse.add(food);
            System.out.println("Продукт " + food.getName() + " добавлен на склад");
            result = true;
        }
        return result;
    }

    @Override
    public boolean test(Food food) {
        long expiryDays = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long endDays = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        return endDays < expiryDays * 0.25;
    }

    @Override
    public List<Food> getFood() {
        return foodInWarehouse;
    }
}
