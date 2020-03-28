package com.teamtreehouse.vending;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphaNumericChooserTest {

    private AlphaNumericChooser chooser;

    @BeforeEach
    void setUp() {
        chooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    void validInputReturnsProperLocation() throws Exception {
        AlphaNumericChooser.Location loc = chooser.locationFromInput("B4");


        assertEquals(1, loc.getRow(), "proper row");
        assertEquals(3, loc.getColumn(), "proper column");
    }

    @Test
    void choosingWrongInputIsNotAllowed() {
        Exception e = assertThrows(InvalidLocationException.class, () -> chooser.locationFromInput("44"));
        assertEquals("Invalid buttons", e.getMessage());
    }

    @Test
    void choosingLargerThanMaxIsNotAllowed() {
        Exception e = assertThrows(InvalidLocationException.class, () -> chooser.locationFromInput("B12"));
        assertEquals("Invalid Location", e.getMessage());
    }

    @Test
    void choosingLargerThanMaxIsNotAllowedAlternative() {
        assertThrows(InvalidLocationException.class, () -> chooser.locationFromInput("B12"));
    }

    @Test
    void constructingLargerThanAlphabetNotAllowed() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new AlphaNumericChooser(27, 10));

        assertEquals("Maximum rows supported is 26", e.getMessage());
    }
}