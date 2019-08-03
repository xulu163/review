package com.xulu.review.array;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedListDemo {

    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        ArrayList newList = new ArrayList(10);
        newList.add("10");
        newList.add("20");
        newList.add("30");
        newList.add("40");
        newList.add("50");

        newList.remove(1);

        newList.add("60");

        CopyOnWriteArrayList<String> ll = new CopyOnWriteArrayList<String>();
        ll.add("100");
        ll.add("200");
        ll.add("200");

        int dd = Collections.binarySearch(ll, "200");

        Set<String> set = new HashSet();
        set.add("12");
        set.add("13");
        set.add("12");
        set.add("14");


    }


    public Object[] dropRepeat(Object[] array){
        Set set = new HashSet();
        for(Object obj : array){
            set.add(obj);
        }
        return set.toArray();
    }
}
