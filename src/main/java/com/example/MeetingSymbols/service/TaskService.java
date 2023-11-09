package com.example.MeetingSymbols.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TaskService {
    public String meetingSymbol(String str) {

        Map<String, Integer> numberСharacter = new HashMap<>();
        StringBuilder resultBuilder = new StringBuilder();
        String[] strArr = str.split("");

        for (String el : strArr) {
            numberСharacter.merge(el, 1, Integer::sum);
        }

        numberСharacter.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> resultBuilder.append("\"" + e.getKey() + "\": " + e.getValue() + ", "));

        resultBuilder.delete(resultBuilder.length() - 2, resultBuilder.length());

        return resultBuilder.toString();
    }
}
