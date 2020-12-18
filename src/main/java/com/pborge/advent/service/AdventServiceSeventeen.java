package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AdventServiceSeventeen {
    @Autowired
    private final WebRepository webRepository;

    private final int BOOT_CYCLES = 6;

    public AdventServiceSeventeen(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        return null;
    }

    public Integer getAdvent2Result() {
        return null;
    }
}
