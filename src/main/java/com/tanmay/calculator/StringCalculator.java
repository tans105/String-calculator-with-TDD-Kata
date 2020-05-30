package com.tanmay.calculator;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers == null || numbers.length() == 0) return 0;

        String[] nums = numbers.split(",");
        int sum = 0;

        for (String number : nums) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
