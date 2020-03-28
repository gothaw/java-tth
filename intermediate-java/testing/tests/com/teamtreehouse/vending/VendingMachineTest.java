package com.teamtreehouse.vending;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    private VendingMachine machine;

    public class NotifierSub implements Notifier {

        @Override
        public void onSale(Item item) {
            return;
        }
    }

    @BeforeEach
    void setUp() throws InvalidLocationException {
        Notifier notifier = new NotifierSub();
        machine = new VendingMachine(notifier, 10, 10, 10);
        machine.restock("A1", "Twinkies", 10, 30, 75);
    }

    @Test
    void vendingWhenStockedReturnsItems() throws InvalidLocationException, NotEnoughFundsException {
        machine.addMoney(75);

        Item item = machine.vend("A1");
        assertEquals("Twinkies", item.getName());
    }
}