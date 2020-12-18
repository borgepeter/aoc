package com.pborge.advent.models;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private final String name;
    private final List<Range> validRanges = new ArrayList<>();

    public Rule(String rawData) {
        this.name = rawData.split(":")[0];
        for (int i = 1; i < 4; i+=2) {
            String[] range = rawData.split(":")[1].split(" ")[i].split("-");
            this.validRanges.add(new Range(range[0], range[1]));
        }
    }

    public boolean isValid(Integer i) {
        for (Range range : validRanges) {
            if (range.isInRange(i))
                return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
