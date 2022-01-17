package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Book bookOne = new Book(1, "Ведьмак: Последнее желание", 420, "Сапковский А.");
    Book bookTwo = new Book(2, "Гиперион", 420, "Симмонс Д.");
    Book bookThree = new Book(3, "Ампир V", 390, "Пелевин В.");
    Book bookFour = new Book(4, "Ведьмак: Башня Ласточки", 420, "Сапковский А.");
    Book bookFive = new Book(5, "Inside Apple", 420, "Лашински А.");

    private SmartPhone smartPhoneOne = new SmartPhone(6, "Mi 9T Pro", 26000, "Xiaomi");
    private SmartPhone smartPhoneTwo = new SmartPhone(7, "Mi 11T Pro", 32500, "Xiaomi");
    private SmartPhone smartPhoneThree = new SmartPhone(8, "11 Pro", 26000, "Apple");
    private SmartPhone smartPhoneFour = new SmartPhone(9, "3310", 3000, "Nokia");

    private Product certificate = new Product(10, "Сертификат на 5000р", 5000);

    @Test
    void searchBookByName() {
        manager.add(bookOne);
        manager.add(bookTwo);
        manager.add(bookThree);
        manager.add(bookFour);
        manager.add(smartPhoneThree);

        Product[] actual = manager.searchBy("Ведьмак");
        Product[] expected = {bookOne, bookFour};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByAuthor() {
        manager.add(bookOne);
        manager.add(bookTwo);
        manager.add(bookThree);
        manager.add(bookFour);

        Product[] actual = manager.searchBy("Пелевин");
        Product[] expected = {bookThree};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchWhenThereAreMatchPhoneAndBook() {
        manager.add(bookThree);
        manager.add(bookFour);
        manager.add(bookFive);
        manager.add(smartPhoneOne);
        manager.add(smartPhoneTwo);
        manager.add(smartPhoneThree);
        manager.add(smartPhoneFour);

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = {bookFive, smartPhoneThree};

        assertArrayEquals(expected, actual);
    }


    @Test
    void searchPhoneByName() {
        manager.add(smartPhoneOne);
        manager.add(smartPhoneTwo);
        manager.add(smartPhoneThree);
        manager.add(smartPhoneFour);

        Product[] actual = manager.searchBy("11");
        Product[] expected = {smartPhoneTwo, smartPhoneThree};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchPhoneByCompany() {
        manager.add(smartPhoneOne);
        manager.add(smartPhoneTwo);
        manager.add(smartPhoneThree);
        manager.add(smartPhoneFour);

        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = {smartPhoneFour};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchWhenNoMatch() {
        manager.add(smartPhoneOne);
        manager.add(smartPhoneTwo);
        manager.add(bookOne);
        manager.add(bookTwo);

        Product[] actual = manager.searchBy("Автомобиль");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchWithoutValue() {
        manager.add(smartPhoneOne);
        manager.add(smartPhoneTwo);
        manager.add(bookOne);
        manager.add(bookTwo);

        Product[] actual = manager.searchBy("");
        Product[] expected = {smartPhoneOne, smartPhoneTwo, bookOne, bookTwo};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchForSequenceOfValuesValues() {
        manager.add(smartPhoneOne);
        manager.add(smartPhoneTwo);
        manager.add(bookOne);
        manager.add(bookTwo);

        Product[] actual = manager.searchBy("MI PRO");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    /// Тесты для методов matches

    @Test
    void shouldSearchBookIfThereAreMatch() {
        Book book = bookThree;

        boolean actual = book.matches("Ампир");
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    void shouldSearchBookIfThereAreNotMatch() {
        Book book = bookThree;

        boolean actual = book.matches("Сапковский");
        boolean expected = false;

        assertEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartPhoneIfThereAreMatch() {
        SmartPhone phone = smartPhoneOne;

        boolean actual = phone.matches("Pro");
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartPhoneIfThereAreNotMatch() {
        SmartPhone phone = smartPhoneOne;

        boolean actual = phone.matches("Nokia");
        boolean expected = false;

        assertEquals(expected, actual);
    }

//    @Test
//    void shouldSearchProductIfThereAreMatch(){
//        Product product = certificate;
//
//        boolean actual = product.matches("Сертификат");
//        boolean expected = true;
//
//        assertEquals(expected,actual);
//    }

//    @Test
//    void shouldSearchProductIfThereAreNotMatch(){
//        Product product = certificate;
//
//        boolean actual = product.matches("Автомобиль");
//        boolean expected = false;
//
//        assertEquals(expected,actual);
//    }


}
