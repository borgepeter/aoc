package com.pborge.advent.service;

import com.pborge.advent.models.MathEvaluator;
import com.pborge.advent.models.MathEvaluatorAddition;
import com.pborge.advent.models.MathEvaluatorBasic;
import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@Service
public class AdventServiceEighteen {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceEighteen(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Long getAdvent1Result() {
        String[] rawData = webRepository.getData(18).split("\n");
        MathEvaluator evaluator = new MathEvaluatorBasic();
        Long sum = 0L;
        for (String expression : rawData) {
            sum += evaluateExpression(expression, evaluator);
        }

        return sum;
    }

    public Long getAdvent2Result() {
        String[] rawData = webRepository.getData(18).split("\n");
        MathEvaluator evaluator = new MathEvaluatorAddition();
        Long sum = 0L;
        for (String expression : rawData) {
            sum += evaluateExpression(expression, evaluator);
        }

        return sum;
    }

    private Long evaluateExpression(String expression, MathEvaluator evaluator) {
        Stack<Queue<String>> operationStack = new Stack<>(){{
            add(new LinkedList<>());
        }};
        Stack<Queue<Long>> numberStack = new Stack<>(){{
            add(new LinkedList<>());
        }};

        for (String component : expression.split(" ")) {
            if (component.length() > 1) {                   // Parenthesis
                if (component.length() > 2) {
                    if (component.contains("((")) {         // Double open
                        operationStack.add(new LinkedList<>());
                        operationStack.add(new LinkedList<>());
                        numberStack.add(new LinkedList<>());
                        numberStack.add(new LinkedList<>());
                        numberStack.peek().add(Long.parseLong(component.substring(2)));
                    } else {                                // Double close
                        numberStack.peek().add(Long.parseLong(component.split("")[0]));
                        long l = evaluator.evaluate(numberStack.pop(), operationStack.pop());
                        numberStack.peek().add(l);
                        l = evaluator.evaluate(numberStack.pop(), operationStack.pop());
                        numberStack.peek().add(l);
                    }
                } else if (component.contains("(")){        // Single open
                    operationStack.add(new LinkedList<>());
                    numberStack.add(new LinkedList<>());
                    numberStack.peek().add(Long.parseLong(component.substring(1)));
                } else {                                    // Single close
                    numberStack.peek().add(Long.parseLong(component.split("")[0]));
                    long l = evaluator.evaluate(numberStack.pop(), operationStack.pop());
                    numberStack.peek().add(l);
                }
            } else {
                try {
                    long l = Long.parseLong(component);    // Number
                    numberStack.peek().add(l);
                } catch (NumberFormatException e) {
                    operationStack.peek().add(component);  // Operator
                }
            }
        }
        Queue<Long> numbers = new LinkedList<>(numberStack.pop());
        Queue<String> operations = new LinkedList<>(operationStack.pop());

        return evaluator.evaluate(numbers, operations);
    }

}
