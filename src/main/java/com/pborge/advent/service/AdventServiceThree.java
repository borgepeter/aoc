package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdventServiceThree {
    @Autowired
    private WebRepository webRepository;

    public AdventServiceThree(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        return getTrees(3, 1);
    }

    public Long getAdvent2Result() {
        Integer[][] slopes = {
                {1, 3, 5, 7, 1},
                {1, 1, 1, 1, 2}
        };
        long result = 1;
        for (int i = 0; i < slopes[0].length; i++)
            result *= getTrees(slopes[0][i], slopes[1][i]);

        return result;
    }

    protected int getTrees(Integer run, Integer rise) {
        String[] data = webRepository.getData(3).split("\n");
        int x = 0;
        int trees = 0;
        for (int i = rise; i < data.length; i += rise) {
            x = (x + run) % data[i].length();
            if (data[i].charAt(x) == '#')
                trees++;
        }
        return trees;
    }
}
