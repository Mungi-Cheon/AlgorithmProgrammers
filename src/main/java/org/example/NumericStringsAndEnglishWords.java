package org.example;

import java.util.HashMap;
import java.util.Map;

public class NumericStringsAndEnglishWords {

    public int solution(String s) {
        Map<String, Integer> eng2Num = createEng2Num();
        for (String eng : eng2Num.keySet()) {
            s = s.replace(eng, String.valueOf(eng2Num.get(eng)));
        }
        return Integer.parseInt(s);
    }

    private Map<String, Integer> createEng2Num() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        return map;
    }

    public static void main(String[] args) {
        String s
            = "one4seveneight";
//            = "23four5six7";
//            = "2three45sixseven";
//            = "123";

        NumericStringsAndEnglishWords app = new NumericStringsAndEnglishWords();
        System.out.println(app.solution(s));
    }
}
