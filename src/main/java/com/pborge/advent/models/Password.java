package com.pborge.advent.models;

public abstract class Password {
    protected String character;
    protected String password;

    public Password(String rawData) {
        this.character = rawData.split(" ")[1].split(":")[0];
        this.password = rawData.split(" ")[2];
    }

    public abstract boolean isValid();
}
