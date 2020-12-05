package com.pborge.advent.models;

import java.util.Arrays;
import java.util.List;

public class Passport {
    private int byr; // (Birth Year)
    private int iyr; // (Issue Year)
    private int eyr; // (Expiration Year)
    private String hgt; // (Height)
    private String hcl; // (Hair Color)
    private String ecl; // (Eye Color)
    private String pid; // (Passport ID)
    private String cid; // (Country ID)
    private boolean isValid = true;

    public Passport(String passportString) {
        try {
            List<String> fields = Arrays.asList(passportString.split("[ \n]"));

            for (String field : fields) {
                String type = field.split(":")[0];
                String value = field.split(":")[1];

                if ("byr".equalsIgnoreCase(type))
                    this.byr = Integer.parseInt(value);
                if ("iyr".equalsIgnoreCase(type))
                    this.iyr = Integer.parseInt(value);
                if ("eyr".equalsIgnoreCase(type))
                    this.eyr = Integer.parseInt(value);
                if ("hgt".equalsIgnoreCase(type))
                    this.hgt = value;
                if ("hcl".equalsIgnoreCase(type))
                    this.hcl = value;
                if ("ecl".equalsIgnoreCase(type))
                    this.ecl = value;
                if ("pid".equalsIgnoreCase(type))
                    this.pid = value;
                if ("cid".equalsIgnoreCase(type))
                    this.cid = value;
            }
        } catch (Exception e) {
            this.isValid = false;
        }
    }

    public boolean isValid() {
        try {
            if (!isValid)
                return false;
            if (byr < 1920 || byr > 2002)
                return false;
            if (iyr < 2010 || iyr > 2020)
                return false;
            if (eyr < 2020 || eyr > 2030)
                return false;
            if (!hgt.matches("\\d{2,3}cm|\\d{2,3}in"))
                return false;
            if (hgt.contains("cm")) {
                int height = Integer.parseInt(hgt.replace("cm", ""));
                if (height < 150 || height > 193)
                    return false;
            }
            if (hgt.contains("in")) {
                int height = Integer.parseInt(hgt.replace("in", ""));
                if (height < 59 || height > 76)
                    return false;
            }
            if (!hcl.matches("#(\\d|.){6}"))
                return false;
            if (!ecl.matches("(amb|blu|brn|gry|grn|hzl|oth)"))
                return false;
            if (!pid.matches("\\d{9}"))
                return false;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }

        return true;
    }
}
