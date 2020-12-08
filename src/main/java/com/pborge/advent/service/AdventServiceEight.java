package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AdventServiceEight {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceEight(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        String[] instructions = webRepository.getData(8).split("\n");
        int[] accumulator = { 0 };
        executeInstructions(instructions, accumulator);
        return accumulator[0];
    }

    public Integer getAdvent2Result() {
        String[] instructions = webRepository.getData(8).split("\n");
        for (int i = 0; i < instructions.length; i++) {
            String task = instructions[i].split(" ")[0];
            int value = Integer.parseInt(instructions[i].split(" ")[1]);

            if ("jmp".equalsIgnoreCase(task) || ("nop".equalsIgnoreCase(task) && value != 0)) {
                int[] accumulator = { 0 };
                String[] newInstructions = instructions.clone();
                newInstructions[i] = newInstructions[i].replace("nop", "new").replace("jmp", "nop").replace("new", "jmp");

                if (executeInstructions(newInstructions, accumulator))
                    return accumulator[0];
            }
        }
        throw new RuntimeException("Unable to fix instructions");
    }

    private boolean executeInstructions(String[] instructions, int[] accumulator) {
        int pointer = 0;
        try {
            HashMap<Integer, Integer> executedSteps = new HashMap<>();
            while (!executedSteps.containsKey(pointer) && pointer >= 0) {
                executedSteps.put(pointer, null);
                String task = instructions[pointer].split(" ")[0];
                int value = Integer.parseInt(instructions[pointer].split(" ")[1]);
                if ("jmp".equalsIgnoreCase(task))
                    pointer += value;
                else {
                    if ("acc".equalsIgnoreCase(task))
                        accumulator[0] += value;
                    pointer++;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return pointer > 0;
        }
        return pointer >= instructions.length;
    }
}
