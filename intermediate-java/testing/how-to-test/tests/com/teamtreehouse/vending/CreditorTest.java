package com.teamtreehouse.vending;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditorTest {

    @Test
    void addingFundsIncrementsAvailableFunds() {
        // Arrange
        Creditor creditor = new Creditor(); // no import needed as it is in the same package

        // Act
        creditor.addFunds(25);
        creditor.addFunds(25);

        // Assert
        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    void refundingReturnsAllAvailableFunds() {
        Creditor creditor = new Creditor();
        creditor.addFunds(10);

        int refund = creditor.refund();

        assertEquals(10, refund);
    }

    @Test
    void refundingResetsAvailableFundsToZero() {
        Creditor creditor = new Creditor();
        creditor.addFunds(5);

        creditor.refund();

        assertEquals(0, creditor.getAvailableFunds());
    }


}