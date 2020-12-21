package com.pborge.advent.models;

import java.util.LinkedList;
import java.util.Queue;

public class MathEvaluatorAddition implements MathEvaluator {
    @Override
    public Long evaluate(Queue<Long> numbers, Queue<String> operations) {
        if (!operations.contains("+") || !operations.contains("*"))
            return new MathEvaluatorBasic().evaluate(numbers, operations);
        Long result = null;
        Queue<Long> multNumbers = new LinkedList<>();
        while (numbers.peek() != null && operations.contains("+")) {
            String operand = operations.peek();
            if ("+".equalsIgnoreCase(operand)) {
                if (result == null) {
                    result = numbers.remove();
                    continue;
                }
                operations.remove();
                result += numbers.remove();
            } else {
                operations.remove();
                if (result == null)
                    multNumbers.add(numbers.remove());
                else {
                    multNumbers.add(result);
                    result = null;
                }
            }
        }
        if (result != null)
            multNumbers.add(result);
        multNumbers.addAll(numbers);
        return multNumbers.stream().reduce(1L, (a,b) -> a*b);
    }
}
