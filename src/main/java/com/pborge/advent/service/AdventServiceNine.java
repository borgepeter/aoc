package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdventServiceNine {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceNine(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Long getAdvent1Result() {
        String[] data = webRepository.getData(9).split("\n");
        for (int i = getPreambleLength() * 2; i < data.length; i++) {
            Long target = Long.parseLong(data[i]);
            if (!isPossible(target, data, i - getPreambleLength()))
                return target;
        }

        throw new RuntimeException("There are no errors here");
    }

    public Long getAdvent2Result() {
        String[] data = webRepository.getData(9).split("\n");
        Long target = getAdvent1Result();
        System.out.println("Target is: " + target);
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (sumsToTarget(target, data, i, j))
                    return result(data, i, j);
            }
        }
        return null;
    }

    protected Integer getPreambleLength() {
        return 25;
    }

    private boolean isPossible(Long target, String[] data, int start) {
        for (int i = start; i < start + getPreambleLength(); i++) {
            for (int j = start + 1; j < start + getPreambleLength() - 1; j++) {
                if (Long.parseLong(data[i]) + Long.parseLong(data[j]) == target)
                    return true;
            }
        }
        return false;
    }

    private boolean sumsToTarget(Long target, String[] data, int start, int end) {
        long sum = 0L;
        for (int i = start; i <= end; i++) {
            sum += Long.parseLong(data[i]);
            if (sum > target)
                return false;
        }

        return sum == target;
    }

    private Long result(String[] data, int start, int end) {
        long max = 0L;
        long min = 9999999999L;
        for (int i = start; i <= end; i++) {
            max = Math.max(Long.parseLong(data[i]), max);
            min = Math.min(Long.parseLong(data[i]), min);
        }
        return min + max;
    }
}
