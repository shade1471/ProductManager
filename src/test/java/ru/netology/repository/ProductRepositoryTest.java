package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Book bookOne = new Book(1, "Ведьмак: Последнее желание", 420, "Сапковский А.");
    Book bookTwo = new Book(2, "Гиперион", 420, "Симмонс Д.");

    SmartPhone smartPhoneOne = new SmartPhone(6, "Mi 9T Pro", 26000, "Xiaomi");
    SmartPhone smartPhoneTwo = new SmartPhone(7, "Mi 11T Pro", 32500, "Xiaomi");


    @Test
    void shouldRemoveById() {
        repository.save(bookOne);
        repository.save(bookTwo);
        repository.save(smartPhoneOne);
        repository.save(smartPhoneTwo);

        repository.removeById(6);

        Product[] expected = {bookOne, bookTwo, smartPhoneTwo};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}