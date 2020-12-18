package com.pborge.advent.service;

import com.pborge.advent.models.Rule;
import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdventServiceSixteen {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceSixteen(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        String rawData = webRepository.getData(16);
        String[] validators = rawData.split("\n\n")[0].split("\n");
        List<Rule> rules = Arrays.stream(validators).map(Rule::new).collect(Collectors.toList());
        String myTicket = rawData.split("\n\n")[1].split("\n")[1];
        String[] otherTickets = rawData.split("\n\n")[2].split("\n");
        otherTickets = Arrays.copyOfRange(otherTickets, 1, otherTickets.length);

        int accum = 0;
        for (String ticket : otherTickets) {
            for (String value : ticket.split(",")) {
                int intVal = Integer.parseInt(value);
                boolean isValid = false;

                for (Rule rule : rules) {
                    if (rule.isValid(intVal)) {
                        isValid = true;
                        break;
                    }
                }

                if (!isValid) {
                    System.out.println(intVal + " is not valid for any rule");
                    accum += intVal;
                }
            }
        }

        return accum;
    }

    public Long getAdvent2Result() {
        String rawData = webRepository.getData(16);
        String[] validators = rawData.split("\n\n")[0].split("\n");
        String[] otherTickets = rawData.split("\n\n")[2].split("\n");
        otherTickets = Arrays.copyOfRange(otherTickets, 1, otherTickets.length);

        List<Rule> rules = Arrays.stream(validators).map(Rule::new).collect(Collectors.toList());
        String myTicket = rawData.split("\n\n")[1].split("\n")[1];
        List<String> validTickets = getValidTickets(rules, otherTickets);
        validTickets.add(myTicket);

        Map<String, Boolean[]> validForRule = createBooleanRuleMap(rules, validTickets);

        Map<String, Integer> ruleIndex = createRuleIndex(validForRule);

        for (String ruleName: ruleIndex.keySet())
            System.out.println(ruleName + ": " + ruleIndex.get(ruleName));

        return ruleIndex.keySet().stream()
                .filter(k -> k.contains("departure"))
                .map(ruleIndex::get)
                .map(i -> myTicket.split(",")[i])
                .map(Long::parseLong)
                .reduce(1L, (a, b) -> a*b);
    }


    private Map<String, Integer> createRuleIndex(Map<String, Boolean[]> validForRule) {
        Map<String, Integer> ruleIndex = new HashMap<>();
        int rulePossibilities = Integer.MAX_VALUE;
        int currentPossibilities = countApplicableRules(validForRule);
        while (rulePossibilities > currentPossibilities) {
            rulePossibilities = currentPossibilities;
            print(validForRule);
            testRules(validForRule, ruleIndex);
            currentPossibilities = countApplicableRules(validForRule);
        }
        return ruleIndex;
    }

    private static void print(Map<String, Boolean[]> validForRule) {
        int paddingLength = validForRule.keySet().stream().map(String::length).reduce(0, Math::max);
        String output = "";
        for (int i = 0; i < paddingLength + 2; i++) output += " ";
        for (int i = 0; i < 20; i++)
            output += i + "  " + (i > 9 ? "" : " ");
        System.out.println(output);
        for (String ruleName : validForRule.keySet()) {
            output = ruleName + ":";
            for (int i = 0; i < paddingLength - ruleName.length(); i++) output += " ";
            for (Boolean isValid : validForRule.get(ruleName))
                output += "[" + (isValid ? "x" : " ") + "] ";
            System.out.println(output);
        }
    }

    private int countApplicableRules(Map<String, Boolean[]> ruleIndex) {
        int counter = 0;
        for (String key : ruleIndex.keySet()) {
            for (Boolean possible : ruleIndex.get(key)) {
                counter += possible ? 1 : 0;
            }
        }
        return counter;
    }

    private void testRules(Map<String, Boolean[]> validForRule, Map<String, Integer> ruleIndex) {
        for (String ruleName : validForRule.keySet()) {
            for (int i = 0; i < validForRule.get(ruleName).length; i++) {
                boolean onlyOneValid = true;
                if (!validForRule.get(ruleName)[i]) // rule is not applicable, skip
                    continue;

                for (String testRule : validForRule.keySet()) {
                    if (testRule.equalsIgnoreCase(ruleName))    // Don't test against yourself
                        continue;
                    for (int j = 0; j < validForRule.get(testRule).length; j++) {
                        if (validForRule.get(testRule)[i])      // Test rule is also applicable, uh-oh
                            onlyOneValid = false;
                    }
                }
                if (onlyOneValid) {
                    ruleIndex.put(ruleName, i);
                    for (int k = 0; k < validForRule.get(ruleName).length; k++) {
                        if (k != i)
                            validForRule.get(ruleName)[k] = false;
                    }
                }
            }
        }
        for (String resolvedRules : ruleIndex.keySet())
            validForRule.remove(resolvedRules);
    }

    private List<String> getValidTickets(List<Rule> rules, String[] otherTickets) {
        List<String> validTickets = new ArrayList<>();

        for (String ticket : otherTickets) {
            boolean isValidTicket = true;
            for (String value : ticket.split(",")) {
                int intVal = Integer.parseInt(value);
                boolean isValidValue = false;

                for (Rule rule : rules) {
                    if (rule.isValid(intVal)) {
                        isValidValue = true;
                        break;
                    }
                }

                if (!isValidValue) {
                    isValidTicket = false;
                    break;
                }
            }
            if (isValidTicket)
                validTickets.add(ticket);
        }
        return validTickets;
    }

    private Map<String, Boolean[]> createBooleanRuleMap(List<Rule> rules, List<String> tickets) {
        Map<String, Boolean[]> validForRule = new HashMap<>();
        for (Rule rule : rules) {
            Boolean[] isValidForAll = new Boolean[tickets.get(0).split(",").length];
            Arrays.fill(isValidForAll, true);
            for (String ticket : tickets) {
                String[] ticketValues = ticket.split(",");
                for (int i = 0; i < ticketValues.length; i++) {
                    isValidForAll[i] = isValidForAll[i] && rule.isValid(Integer.parseInt(ticketValues[i]));
                }
            }
            validForRule.put(rule.getName(), isValidForAll);
        }
        return validForRule;
    }
}
