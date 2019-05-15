package com.xulu.review.oom;


/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-05-11 20:11
 **/
public class JavaHeapSapceDemo {

    public static void main(String[] args) {

        /**
         * 设置堆内存为10m，-Xms10m -Xmx10m
         * 堆内存干爆了，实际10m，创建了个80m的大对象
         * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
         */
        byte[] bytes = new byte[80  * 1024 * 1024];

    }
}
