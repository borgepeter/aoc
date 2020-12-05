package com.pborge.advent.service;

import com.pborge.advent.models.Passport;
import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdventServiceFour {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceFour(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        List<String> passports = Arrays.asList(webRepository.getData(4).split("\n\n"));
        int validPassports = 0;
        for (String passport : passports) {
            if (hasCompleteData(passport))
                validPassports++;
        }

        return validPassports;
    }

    public Integer getAdvent2Result() {
        List<String> passports = Arrays.asList(webRepository.getData(4).split("\n\n"));
        int validPassports = 0;
        for (String passport : passports) {
            if (hasCompleteData(passport) && hasValidData(passport))
                validPassports++;
        }

        return validPassports;
    }

    private static boolean hasCompleteData(String passport) {
        return
            passport.contains("byr") &&
            passport.contains("iyr") &&
            passport.contains("eyr") &&
            passport.contains("hgt") &&
            passport.contains("hcl") &&
            passport.contains("ecl") &&
            passport.contains("pid");
    }

    private boolean hasValidData(String passportString) {
        Passport passport = new Passport(passportString);
        return passport.isValid();
    }
}
