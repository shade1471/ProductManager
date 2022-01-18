package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartPhoneTest {
    SmartPhone smartPhoneOne = new SmartPhone(6, "Mi 9T Pro", 26000, "Xiaomi");

    @Test
    void shouldSearchSmartPhoneIfThereAreMatch() {
        SmartPhone phone = smartPhoneOne;

        boolean actual = phone.matches("Pro");

        assertTrue(actual);
    }

    @Test
    void shouldSearchSmartPhoneIfThereAreNotMatch() {
        SmartPhone phone = smartPhoneOne;

        boolean actual = phone.matches("Nokia");

        assertFalse(actual);
    }

}
