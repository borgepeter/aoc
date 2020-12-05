package com.pborge.advent.models;

public class PasswordValidationModelTwo extends Password {
    private final int locationA;
    private final int locationB;

    public PasswordValidationModelTwo(String rawData) {
        super(rawData);
        this.locationA = Integer.parseInt(rawData.split("-")[0]);
        this.locationB = Integer.parseInt(rawData.split("-")[1].split(" ")[0]);
    }

    public boolean isValid() {
        if (password == null)
            return false;
        if (!password.contains(character))
            return false;

        char c = character.charAt(0);
        return password.charAt(locationA - 1) == c ^ password.charAt(locationB - 1) == c;
    }
}
