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
        assertEquals(StringCalculator.add("1,2,"), 3);
    }

    @Test
    public void shouldReturnSumOfTwoNumbersWithMultipleArguments() {
        assertEquals(StringCalculator.add("1,2,3"), 6);
        assertEquals(StringCalculator.add("1,2,3,4,5,6,"), 21);
    }

}
