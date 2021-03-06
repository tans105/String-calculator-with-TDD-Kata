package com.tanmay.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

    @Test
    public void shouldReturnSumOfTwoNumbersWithNewLineDelimiter() {
        assertEquals(StringCalculator.add("1\n"), 1);
        assertEquals(StringCalculator.add("1\n2,3"), 6);
        assertEquals(StringCalculator.add("1\n2\n3"), 6);
        assertEquals(StringCalculator.add("1\n2\n3\n"), 6);
    }

    @Test
    public void shouldReturnSumOfTwoNumbersWithCustomDelimiter() {
        assertEquals(StringCalculator.add("//;\n1;2"), 3);
        assertEquals(StringCalculator.add("//|\n1|2"), 3);
    }

    @Test
    public void shouldThrowAnExceptionWithNegative() {
        try {
            StringCalculator.add("//;\n-1;4");
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
            assertEquals("negatives not allowed -1", e.getMessage());
        }
    }

    @Test
    public void shouldIgnoreNumbersGreaterThan1000() {
        assertEquals(StringCalculator.add("1000"), 1000);
        assertEquals(StringCalculator.add("1001"), 0);
        assertEquals(StringCalculator.add("1,2000,3"), 4);
        assertEquals(StringCalculator.add("1\n2\n3\n1020"), 6);
    }

    @Test
    public void shouldHandleMultipleSingleCharacterDelimiter() {
        assertEquals(StringCalculator.add("//;*\n1;2*3"), 6);
        assertEquals(StringCalculator.add("//|*;\n1;2*3|4"), 10);
    }

    @Test
    public void shouldHandleMultipleCharacterDelimiters() {
        assertEquals(StringCalculator.add("//***\n1***2***3"), 6);
        assertEquals(StringCalculator.add("//|||\n1|||2|||3|||4"), 10);
    }
}
