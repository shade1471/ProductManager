package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book bookThree = new Book(3, "Ампир V", 390, "Пелевин В.");

    @Test
    void shouldSearchBookIfThereAreMatch() {
        Book book = bookThree;

        boolean actual = book.matches("Ампир");

        assertTrue(actual);
    }

    @Test
    void shouldSearchBookIfThereAreNotMatch() {
        Book book = bookThree;

        boolean actual = book.matches("Сапковский");

        assertFalse(actual);
    }

}