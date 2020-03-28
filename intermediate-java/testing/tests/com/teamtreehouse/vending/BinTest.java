package com.teamtreehouse.vending;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinTest {

    private Bin bin;


    @BeforeEach
    void setUp() {
        bin = new Bin(10);
    }

    @Test
    void restockingWithDifferentItemsIsNotAllowed() {

        assertThrows(IllegalArgumentException.class, () -> {
            bin.restock("Cheetos", 1, 100, 50);
            bin.restock("Doritos", 1, 100, 50);
        });

    }

    @Test
    void whenEmptyPriceIsZero() {
        assertEquals(0, bin.getItemPrice());
    }

    @Test
    void whenEmptyNameIsNull() {
        assertNull(bin.getItemName());
    }

    @Test
    void overstockingNotAllowed() {

        Exception e = assertThrows(IllegalArgumentException.class, () -> bin.restock("Fritos", 2600, 100, 50));
        assertEquals("There are only 10 spots left", e.getMessage());

    }
}