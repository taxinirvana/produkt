package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Book extends Product {
    private String author;

    public Book() {
        super();
    }

    public Book(int id, String title, int cost, String author) {
        super(id, title, cost);
        this.author = author;
    }
}
