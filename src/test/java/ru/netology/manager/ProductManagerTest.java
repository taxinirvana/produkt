package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product one = new Book(1, "Secret", 15, "Ivanov");
    Product two = new Book(2, "Animals", 20, "Petrov");
    Product three = new Smartphone(3, "Phone", 100, "Russia");
    Product four = new Smartphone(4, "New Phone", 120, "Germany");

    @Test
    public void shouldUseSearchBy() {
        manager.add(one);
        manager.add(two);
        manager.add(four);
        manager.searchBy("Animals");

        Product[] expected = new Product[]{two};
        Product[] actual = manager.searchBy("Animals");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByOneElement() {
        manager.add(one);
        manager.searchBy("Secret");

        Product[] expected = new Product[]{one};
        Product[] actual = manager.searchBy("Secret");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByNoElement() {
        manager.searchBy("Secret");

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Secret");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByNoText() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.searchBy("New Phone");

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("New Phone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByNoTextOneElement() {
        manager.add(three);
        manager.searchBy("New Phone");

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("New Phone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByNoTextNoElement() {
        manager.searchBy("New Phone");

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("New Phone");

        assertArrayEquals(expected, actual);
    }

}