package com.tanmay.calculator;

import java.util.HashSet;
import java.util.Set;

public class CalculatorContext {
    private String text;
    private boolean isCustom = false;
    private String effectiveString;
    private String delimiter;

    public CalculatorContext(String text) {
        this.text = text;
        init();
    }

    private void init() {
        String[] chunks = text.split("\n");
        if (text.startsWith("//")) {
            isCustom = true;
            effectiveString = chunks[1];
        } else {
            effectiveString = text;
        }
        delimiter = getCustomDelimiter(chunks[0]);
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getText() {
        return text;
    }

    public boolean isCustom() {
        return isCustom;
    }

    public String getEffectiveString() {
        return effectiveString;
    }

    @Override
    public String toString() {
        return "{" + "text='" + text + ", isCustom=" + isCustom + ", effectiveString=" + effectiveString + ", delimiter=" + delimiter + '}';
    }

    public String[] getNumbers() {
        return effectiveString.split(delimiter);
    }


    private String getCustomDelimiter(String line) {
        Set<Character> charSet = new HashSet<>();
        if (isCustom) {
            line = line.substring(2);
            StringBuilder multilineDelimiter = new StringBuilder();
            for (Character delimiter : line.toCharArray()) {
                multilineDelimiter.append("[");
                multilineDelimiter.append(delimiter);
                multilineDelimiter.append("]");
                charSet.add(delimiter);
            }

            if (charSet.size() == 1) {
                return multilineDelimiter.toString();
            }

            return "[" + line + "]";
        }
        return "[\n,]";
    }
}
