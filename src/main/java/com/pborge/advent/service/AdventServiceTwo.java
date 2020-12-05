package com.pborge.advent.service;

import com.pborge.advent.models.Password;
import com.pborge.advent.models.PasswordValidationModelOne;
import com.pborge.advent.models.PasswordValidationModelTwo;
import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdventServiceTwo {
    @Autowired
    private WebRepository webRepository;

    public AdventServiceTwo(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Long getAdvent1Result() {
        List<String> data = Arrays.asList(webRepository.getData(2).split("\n"));
        return data.stream().map(PasswordValidationModelOne::new).filter(Password::isValid).count();
    }

    public Long getAdvent2Result() {
        List<String> data = Arrays.asList(webRepository.getData(2).split("\n"));
        return data.stream().map(PasswordValidationModelTwo::new).filter(Password::isValid).count();
    }
}
