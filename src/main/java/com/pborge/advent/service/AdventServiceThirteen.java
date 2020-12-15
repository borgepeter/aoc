package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdventServiceThirteen {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceThirteen(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        String[] data = webRepository.getData(13).split("\n");
        int departureTime = Integer.parseInt(data[0]);
        List<Integer> busIds = Arrays.stream(data[1].split(","))
                .filter(s -> !"x".equalsIgnoreCase(s))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int selectedBusId = -1;
        int waitTime = 9999999;
        for (Integer busId : busIds) {
            int waitForBus = ((departureTime / busId) * busId + busId) - departureTime;
            if (waitTime > waitForBus) {
                selectedBusId = busId;
                waitTime = waitForBus;
            }
        }

        return selectedBusId * waitTime;
    }

    /**
     * Shoutout to Maths with Jay (https://www.youtube.com/watch?v=zIFehsBHB8o)
     * for teaching the Chinese Remainder Theorum
     * @return
     */
    public Long getAdvent2Result() {
        String[] incongruences = webRepository.getData(13).split("\n")[1].split(",");
        int counter = (int)Arrays.stream(incongruences).filter(s -> !"x".equalsIgnoreCase(s)).count();
        Integer[] remainder = new Integer[counter];
        Integer[] mods = new Integer[counter];
        counter = 0;
        for (int i = 0; i < incongruences.length; i++) {
            if (!"x".equalsIgnoreCase(incongruences[i])) {
                mods[counter] = Integer.parseInt(incongruences[i]);
                int multiplier = 1;
                while ((mods[counter] * multiplier) - i < 0)
                    multiplier++;
                remainder[counter] = (mods[counter] * multiplier) - i;
                System.out.println(counter+". x = " + remainder[counter] + " (mod " + mods[counter] + ")");
                counter++;
            }
        }

        BigInteger N = BigInteger.ONE;
        for (Integer mod : mods) N = N.multiply(BigInteger.valueOf(mod));

        BigInteger[] lowestCommonFactor = new BigInteger[counter];
        for (int i = 0; i < remainder.length; i++)
            lowestCommonFactor[i] = N.divide(BigInteger.valueOf(mods[i]));

        Integer[] inverse = findInverse(lowestCommonFactor, mods);

        BigInteger[] product = new BigInteger[counter];
        for (int i = 0; i < remainder.length; i++)
            product[i] = BigInteger.valueOf(remainder[i]).multiply(lowestCommonFactor[i]).multiply(BigInteger.valueOf(inverse[i]));

        BigInteger sum = BigInteger.ZERO;
        for (BigInteger bigInteger : product) sum = sum.add(bigInteger);

        // Debug logging
        for (int i = 0; i < counter; i++) {
            if (i == 0)
                System.out.println("\tremainder\tLCF\tinverse\tproduct");
            System.out.println(i+".\t" + remainder[i] + "\t\t"+ lowestCommonFactor[i] + "\t\t" + inverse[i] + "\t\t" + product[i]);
        }

        return sum.mod(N).longValue();
    }

    private Integer[] findInverse(BigInteger[] ni, Integer[] mods) {
        Integer[] xi = new Integer[mods.length];
        for (int i = 0; i < mods.length; i++) {
            BigInteger bigMod = BigInteger.valueOf(mods[i]);
            if (ni[i].mod(bigMod).compareTo(BigInteger.ONE) == 0)
                xi[i] = 1;
            else {
                int remainder = ni[i].mod(bigMod).intValue();
                int j = 1;
                while (j < 10000) {
                    if (j * remainder % mods[i] == 1) {
                        xi[i] = j;
                        break;
                    }
                    j++;
                }
            }
        }
        return xi;
    }
}
