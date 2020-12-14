package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdventServiceTwelve {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceTwelve(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        return null;
    }

    public Integer getAdvent2Result() {
        return null;
    }
}
