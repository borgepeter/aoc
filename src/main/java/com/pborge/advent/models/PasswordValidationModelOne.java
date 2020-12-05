package com.pborge.advent.models;

public class PasswordValidationModelOne extends Password {
    private final int minLength;
    private final int maxLength;

    public PasswordValidationModelOne(String rawData) {
        super(rawData);
        this.minLength = Integer.parseInt(rawData.split("-")[0]);
        this.maxLength = Integer.parseInt(rawData.split("-")[1].split(" ")[0]);
    }

    public boolean isValid() {
        if (password == null)
            return false;
        if (password.length() < minLength)
            return false;
        if (!password.contains(character))
            return false;

        int occurrences = password.length() - password.replaceAll(character, "").length();

        return (occurrences >= minLength && occurrences <= maxLength);
    }
}
