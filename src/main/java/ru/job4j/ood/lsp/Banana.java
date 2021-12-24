package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.Date;

public class Banana extends Food {

    public Banana(String name, LocalDate expiryDate, LocalDate createDate, float price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
