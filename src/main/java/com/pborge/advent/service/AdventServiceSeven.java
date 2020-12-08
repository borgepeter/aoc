package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdventServiceSeven {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceSeven(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        String[] rawData = webRepository.getData(7).split("\n");
        final String TARGET = "shiny gold";
        List<String> outerBags = new ArrayList<>();
        findEnclosingBags(TARGET, rawData, outerBags);
        return outerBags.size();
    }

    public Integer getAdvent2Result() {
        String[] rawData = webRepository.getData(7).split("\n");
        final String TARGET = "shiny gold";
        return findEnclosedBags(TARGET, rawData, -1); // -1 because we don't want to count the TARGET bag.
    }

    private void findEnclosingBags(String bagType, String[] rules, List<String> bagList) {
        for (String rule : rules) {
            String enclosingBag = enclosingBag(rule);
            if (containsBag(bagType, rule) && !bagList.contains(enclosingBag)) {
                bagList.add(enclosingBag);
                findEnclosingBags(enclosingBag(rule), rules, bagList);
            }
        }
    }

    private boolean containsBag(String bagType, String rule) {
        return rule.split("contain")[1].contains(bagType);
    }

    private String enclosingBag(String rule) {
        return rule.split("bags")[0].trim();
    }

    private Integer findEnclosedBags(String target, String[] rules, Integer total) {
        for (String rule : rules) {
            String enclosingBag = enclosingBag(rule);
            if (target.equalsIgnoreCase(enclosingBag)) {
                Map<String, Integer> enclosedBags = getEnclosedBags(rule);
                if (enclosedBags.isEmpty()) {
                    return 1;
                }
                for (String enclosedBag : enclosedBags.keySet()) {
                    Integer innerBags = 0;
                    total += enclosedBags.get(enclosedBag) * findEnclosedBags(enclosedBag, rules, innerBags);
                }
                total = total + 1;
                return total;
            }
        }

        throw new RuntimeException("No rules for target bag type");
    }

    private Map<String, Integer> getEnclosedBags(String rule) {
        Map<String, Integer> bags = new HashMap<>();
        if (rule.contains("no other bags"))
            return bags;

        for (String bagData : rule.split("contain")[1].split(",")) {
            String[] bagDataArr = bagData.trim().split(" ");
            bags.put((bagDataArr[1] + " " + bagDataArr[2]).trim(), Integer.parseInt(bagDataArr[0].trim()));
        }
        return bags;
    }
}
