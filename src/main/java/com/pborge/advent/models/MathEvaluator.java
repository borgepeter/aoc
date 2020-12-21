package com.pborge.advent.models;

import java.util.Queue;

public interface MathEvaluator {
    Long evaluate(Queue<Long> numbers, Queue<String> operations);
}
