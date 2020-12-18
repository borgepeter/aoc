package com.pborge.advent.models;

public class Range {
    private final Integer upperBound;
    private final Integer lowerBound;

    protected Range(String lowerBound, String upperBound) {
        this.upperBound = Integer.parseInt(upperBound);
        this.lowerBound = Integer.parseInt(lowerBound);
    }

    protected Range(Integer lowerBound, Integer upperBound) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }

    protected boolean isInRange(Integer i) {
        return lowerBound <= i && i <= upperBound;
    }
}
