package com.oneio.fuzzbizzgame.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class FizzBuzzService {
    @Value("#{${reference.map}}")
    HashMap<Integer, String> referenceMap;

    public String getFuzzBizzOutput(Integer number) {
        ArrayList<String> output = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            StringBuilder s = new StringBuilder();
            for (Integer key : referenceMap.keySet()) {
                if ((i % key) == 0) {
                    s.append(referenceMap.get(key));
                }
            }
            if (s.toString().equals("")) {
                s.append(i);
            }
            output.add(s.toString());

        }
        return String.join(", ", output);
    }
}
