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
        if (text.startsWith("//")) {
            isCustom = true;
            String[] chunks = text.split("\n");
            delimiter = "[" + chunks[0].substring(2) + "]";
            effectiveString = chunks[1];
        } else {
            delimiter = "[\n,]";
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
}
