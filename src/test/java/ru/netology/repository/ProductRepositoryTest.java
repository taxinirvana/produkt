package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Product one = new Book(1, "Secret", 15, "Ivanov");
    Product two = new Book(2, "Animals", 20, "Petrov");
    Product three = new Smartphone(3, "Phone", 100, "Russia");
    Product four = new Smartphone(4, "New Phone", 120, "Germany");

    @Test
    public void shouldSaveAllProduct() {
        repository.save(one);
        repository.save(two);

        Product[] expected = new Product[]{one, two};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveAllProductOneElement() {
        repository.save(one);

        Product[] expected = new Product[]{one};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveAllProductNoElement() {

        Product[] expected = new Product[0];
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveItem() {
       int id = 3;
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);

        Product[] expected = new Product[]{one, two, four};
        Product[] actual = repository.removeById(3);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveItemOneElement() {
        repository.save(two);

        Product[] expected = new Product[0];
        Product[] actual = repository.removeById(2);
        assertArrayEquals(expected, actual);
    }

}