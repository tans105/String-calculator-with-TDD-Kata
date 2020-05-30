package com.tanmay.calculator;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers == null || numbers.length() == 0) return 0;
        int sum = 0;

        CalculatorContext context = new CalculatorContext(numbers);
        String[] numberList = context.getNumbers();
        for (String number : numberList) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
