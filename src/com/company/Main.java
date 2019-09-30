package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D://Harry.txt")));
        System.out.println(content.length());

        content = content.toLowerCase();
        content = content.replaceAll("[^a-z' ]"," ");
       String[] array  =  content.split("\\s+");
       Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            //System.out.println(array[i]);
            int count = 0;
            String word = array[i];
            if (map.keySet().contains(word)) {
                count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }
            Map result = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            result.entrySet().stream().forEach(System.out::println);


        System.out.println(content.substring(0, 300));
    }
}
