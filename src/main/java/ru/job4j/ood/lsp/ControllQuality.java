package ru.job4j.ood.lsp;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

public class ControllQuality {

   private final List<Store> stores;

    public ControllQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void distributeFood(Food food) {
        for (Store store : stores) {
            store.add(food);
        }
    }

    public void resort() {
        List<Food> products = new ArrayList<>();
        for (Store store : stores) {
            products.addAll(store.getFood());
            store.getFood().clear();
        }
        for (Food food : products) {
            distributeFood(food);
        }
    }

    public static void main(String[] args) {
        Store shop = new Shop(new ArrayList<>());
        Store warehouse = new Warehouse(new ArrayList<>());
        Store trash = new Trash(new ArrayList<>());
        ControllQuality controllQuality = new ControllQuality(List.of(shop, warehouse, trash));
        Food banana = new Banana("banana", LocalDate.of(2022, 1, 30), LocalDate.of(2021, 12, 20), 60, 5);
        Food bread = new Bread("bread", LocalDate.of(2021, 12, 31), LocalDate.of(2021, 12, 22), 100, 5);
        Food milk = new Milk("milk", LocalDate.of(2021, 12, 31), LocalDate.of(2021, 12, 10), 100, 5);
        Food badMilk = new Milk("bad_milk", LocalDate.of(2021, 12, 20), LocalDate.of(2021, 12, 1), 70, 10);
        System.out.println("До перераспределения:");
        controllQuality.distributeFood(banana);
        controllQuality.distributeFood(bread);
        controllQuality.distributeFood(milk);
        controllQuality.distributeFood(badMilk);
        System.out.println(System.lineSeparator());
        System.out.println("После перераспределения:");
        bread.setExpiryDate(LocalDate.of(2021, 12, 26));
        milk.setExpiryDate(LocalDate.of(2022, 2, 28));
        banana.setExpiryDate(LocalDate.of(2021, 12, 31));
        controllQuality.resort();
    }
}
