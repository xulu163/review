package com.xulu.review.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockemo {
    /**
     * 公平锁：是指多个线程按照申请的顺序来获取锁，类似排队打饭，先来后到
     *
     * 非公平锁：直接尝试占有锁，如果尝试失败，就采用类似公平锁的方式获取
     *
     * 可重入锁：又名递归锁，指的是统一线程外层函数获得锁之后，内层递归函数仍然能获得改锁的代码，在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁，也就是说，线程可以进入任何一个他已经拥有的锁的锁同步着的代码块
     *
     * 非公平锁的优点在于吞吐量大，对于synchronized而言，是一种非公平锁
     */

    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){

    }

    public static void main(String[] args){



    }
}
