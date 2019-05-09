package com.xulu.review.array;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类练习
 */
public class ArrayDemo {

    public static void main(String[] args){

        List<String> list = new CopyOnWriteArrayList(); //Collections.synchronizedList(new ArrayList());

        for(int i = 1; i < 30; i++){
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

    }

    /**
     * ArrayList是线程不安全的，Vector是线程安全的
     *
     * 1.故障现象：java.util.ConcurrentModificationException
     *
     * 2.导致原因：并发争抢修改导致
     *
     * 3.解决方案：
     *      3.1使用Vector
     *      3.2使用Collections工具类
     *      3.3使用CopyOnWriteArrayList,俗称写时复制
     *
     * 4.优化建议：
     */
}
