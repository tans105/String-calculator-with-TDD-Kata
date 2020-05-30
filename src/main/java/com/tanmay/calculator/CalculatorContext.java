package com.tanmay.calculator;

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
            delimiter = "[" + getCustomDelimiter(chunks[0]) + "]";
            effectiveString = chunks[1];
        } else {
            delimiter = "[\n" + getCustomDelimiter(chunks[0]) + "]";
            effectiveString = text;
        }
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
        if (isCustom) {
            return line.substring(2);
        }
        return "[\n,]";
    }
}
