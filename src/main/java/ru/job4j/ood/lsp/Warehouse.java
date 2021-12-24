package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.Period;
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
            System.out.println("Продукт добавлен на склад");
            result = true;
        }
        return result;
    }

    @Override
    public boolean test(Food food) {
        long expiryDays = Period.between(food.getCreateDate(), food.getExpiryDate()).getDays();
        long endDays = Period.between(food.getCreateDate(), LocalDate.now()).getDays();
        return endDays < expiryDays * 0.25;
    }
}
