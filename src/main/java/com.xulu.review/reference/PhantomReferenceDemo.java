package com.xulu.review.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 *
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-05-11 19:39
 **/
public class PhantomReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, referenceQueue);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("=======================");

    }
}
