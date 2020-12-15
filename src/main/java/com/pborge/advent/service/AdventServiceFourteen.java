package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdventServiceFourteen {
    @Autowired
    private final WebRepository webRepository;

    private final int MASK_LENGTH = 36;

    public AdventServiceFourteen(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public long getAdvent1Result() {
        String[] data = webRepository.getData(14).split("\n");
        String[] mask = new String[MASK_LENGTH];
        Map<Integer, Long> ret = new HashMap<>();

        for (String line : data) {
            if (line.contains("mask"))
                mask = line.split(" ")[2].split("");
            else {
                int address = Integer.parseInt(line.split("\\[")[1].split("]")[0]);
                long value = Long.parseLong(line.split(" ")[2]);
                String[] binaryValue = Long.toBinaryString(value).split("");
                ret.put(address, Long.parseLong(applyMaskV1(binaryValue, mask), 2));
            }

        }

        return ret.values().stream().reduce(0L, Long::sum);
    }

    public Long getAdvent2Result() {
        String[] data = webRepository.getData(14).split("\n");
        String[] mask = new String[MASK_LENGTH];
        Map<Long, Long> ret = new HashMap<>();

        for (String line : data) {
            if (line.contains("mask"))
                mask = line.split(" ")[2].split("");
            else {
                long addressLong = Long.parseLong(line.split("\\[")[1].split("]")[0]);
                long value = Long.parseLong(line.split(" ")[2]);
                String[] binaryAddress = Long.toBinaryString(addressLong).split("");
                for (StringBuilder address : applyMaskV2(binaryAddress, mask))
                    ret.put(Long.parseLong(address.toString(), 2), value);
            }

        }

        return ret.values().stream().reduce(0L, Long::sum);
    }

    private String applyMaskV1(String[] binaryValue, String[] mask) {
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= mask.length; i++) {
            switch (mask[MASK_LENGTH - i]) {
                case "X":
                    if (binaryValue.length >= i)
                        output = output.insert(0, binaryValue[binaryValue.length - i]);
                    else
                        output.insert(0, "0");
                    break;
                case "1":
                    output.insert(0, "1");
                    break;
                case "0":
                    output.insert(0, "0");
                    break;
            }
        }
        return output.toString();
    }

    private List<StringBuilder> applyMaskV2(String[] binaryAddress, String[] mask) {
        List<StringBuilder> outputList = new ArrayList<>(){{
            add(new StringBuilder());
        }};
        for (int i = 1; i <= mask.length; i++) {
            switch (mask[MASK_LENGTH - i]) {
                case "X":
                    List<StringBuilder> temp = new ArrayList<>();
                    for (StringBuilder sb : outputList) {
                        StringBuilder clonedSB = new StringBuilder(sb);
                        sb.insert(0, "0");
                        clonedSB.insert(0, "1");
                        temp.add(clonedSB);
                    }
                    outputList.addAll(temp);
                    break;
                case "1":
                    updateOutput(outputList, "1");
                    break;
                case "0":
                    if (binaryAddress.length >= i)
                        updateOutput(outputList, binaryAddress[binaryAddress.length - i]);
                    else
                        updateOutput(outputList, "0");
                    break;
            }
        }
        return outputList;
    }

    private void updateOutput(List<StringBuilder> stringBuilders, String append) {
        for (StringBuilder sb : stringBuilders)
            sb.insert(0, append);
    }
}
