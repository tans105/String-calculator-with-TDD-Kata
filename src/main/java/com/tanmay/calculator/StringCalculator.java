package com.tanmay.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers == null || numbers.length() == 0) return 0;
        int sum = 0;
        List<String> negatives = new ArrayList<>();

        CalculatorContext context = new CalculatorContext(numbers);
        String[] numberList = context.getNumbers();
        for (String number : numberList) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                negatives.add(number);
            }

            if(num > 1000) {
                continue;
            }
            sum += num;
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                    "negatives not allowed " + String.join(",", negatives));
        }

        return sum;
    }
}
