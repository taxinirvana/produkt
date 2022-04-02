package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String title, int cost, String manufacturer) {
        super(id, title, cost);
        this.manufacturer = manufacturer;
    }
}
