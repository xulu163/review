package com.xulu.review.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-05-11 20:23
 **/
public class GcOverheadLimitExceededDemo {

    /**
     * -Xms10m
     * -Xmx10m
     * -XX:+PrintGCDetails
     * -XX:MaxDirectMemorySize=5m
     *
     * 大量的资源被dc耗去做垃圾回收
     * gc回收内存时间过长时会跑出OutOfMemoryError
     */

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try{
            while(true){
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e){
            System.out.println("***********i="+i);
            e.printStackTrace();
            throw e;
        }


    }
}
