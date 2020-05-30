package com.tanmay.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroOnNullString() {
        assertEquals(StringCalculator.add(null), 0);
    }

    @Test
    public void shouldReturnZeroOnEmptyString() {
        assertEquals(StringCalculator.add(""), 0);
    }

    @Test
    public void shouldReturnSumOfTwoNumbersWithSingleArgument() {
        assertEquals(StringCalculator.add("2"), 2);
    }

    @Test
    public void shouldReturnSumOfTwoNumbersWithTwoArgumets() {
        assertEquals(StringCalculator.add("1,2"), 3);
    }
}
