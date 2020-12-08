package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdventServiceSix {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceSix(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        String[] customsInfo = webRepository.getData(6).split("\n\n");
        int total = 0;
        for (String info : customsInfo) {
            char[] chars = info.replaceAll("\n", "").toCharArray();
            Set<Character> present = new HashSet<>();
            int len = 0;
            for (char c : chars)
                if (present.add(c))
                    chars[len++] = c;

            total += len;
        }
        return total;
    }

    public Integer getAdvent2Result() {
        String[] customsInfos = webRepository.getData(6).split("\n\n");
        int total = 0;
        for (String customsInfo : customsInfos) {
            String[] lines = customsInfo.split("\n");
            if (lines.length == 1)
                total += lines[0].length();
            else {
                Map<String, Integer> results = new HashMap<>();
                for (String line : lines) {
                    for (String result : line.split(""))
                        results.put(result, results.getOrDefault(result, 0) + 1);
                }
                for (String key : results.keySet())
                    if (results.get(key) == lines.length)
                        total++;
            }
        }
        return total;

    }
}
