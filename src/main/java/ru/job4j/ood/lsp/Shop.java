package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Shop implements Store {

    private List<Food> foodInShop;

    public Shop(List<Food> foodInShop) {
        this.foodInShop = foodInShop;
    }

    public List<Food> getFoodInShop() {
        return foodInShop;
    }

    public void setFoodInShop(List<Food> foodInShop) {
        this.foodInShop = foodInShop;
    }

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (test(food)) {
            foodInShop.add(food);
            System.out.println("Продукт добавлен в магазин");
            result = true;
        }
        return result;
    }

    @Override
    public boolean test(Food food) {
        boolean result = false;
        long expiryDays = Period.between(food.getCreateDate(), food.getExpiryDate()).getDays();
        long endDays = Period.between(food.getCreateDate(), LocalDate.now()).getDays();
        if (endDays > expiryDays * 0.25 && endDays < expiryDays) {
            result = true;
            if (endDays > expiryDays * 0.75) {
                food.setPrice((food.getPrice() / 100) * (100 - food.getDiscount()));
            }
        }
        return result;
    }
}
