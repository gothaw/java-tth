package com.teamtreehouse.vending;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditorTest {

    private Creditor creditor;

    @BeforeEach
    void setUp() {
        creditor = new Creditor();
    }

    @Test
    void addingFundsIncrementsAvailableFunds() {
        // Act
        creditor.addFunds(25);
        creditor.addFunds(25);

        // Assert
        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    void refundingReturnsAllAvailableFunds() {
        // Arrange
        creditor.addFunds(10);

        // Act
        int refund = creditor.refund();

        // Assert
        assertEquals(10, refund);
    }

    @Test
    void refundingResetsAvailableFundsToZero() {
        creditor.addFunds(5);

        creditor.refund();

        assertEquals(0, creditor.getAvailableFunds());
    }


}