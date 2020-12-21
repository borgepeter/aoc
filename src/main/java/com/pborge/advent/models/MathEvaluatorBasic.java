package com.pborge.advent.models;

import java.util.Queue;

public class MathEvaluatorBasic implements MathEvaluator {
    @Override
    public Long evaluate(Queue<Long> numbers, Queue<String> operations) {
        Long result = null;
        while (numbers.peek() != null) {
            if (result == null) {
                result = numbers.remove();
                continue;
            }
            String operand = operations.remove();
            if ("+".equalsIgnoreCase(operand)) {
                result += numbers.remove();
            } else if ("*".equalsIgnoreCase(operand)) {
                result *= numbers.remove();
            }
        }
        return result;
    }
}
