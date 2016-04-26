package com.testproject.springmvc.services;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class TextService
{
    public HashMap<String,Integer>splitText(String str){

        List<String> words = new ArrayList<String>();
        Matcher match = Pattern.compile("[0-9]+|[a-z']+|[A-Z']+").matcher(str);
        while (match.find()) {
            words.add(match.group());
        }
        HashMap<String,Integer> map = new HashMap<>();
        Integer amount;
        for (String w : words) {

            amount = map.get(w);
            map.put(w, amount == null ? 1 : amount + 1);
        }

        for(Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            if(entry.getKey().length() < 2 | entry.getValue().equals(1)) {
                it.remove();
            }
        }
        return map;
    }


}
