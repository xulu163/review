package com.xulu.review.array;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("1", 1);
        map.put("2", 1);
        map.put("3", 1);
        map.put("4", 1);
        map.put("5", 1);
        map.put("6", 1);
        map.put("6", 2);
        map.put("6", 3);
        map.put("6", 4);
        System.out.println(map.entrySet());
        System.out.println(map.toString());
    }
}
