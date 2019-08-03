package com.xulu.review.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {

    }
}

class MyCache{ //资源类

    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    public void put(String key, Object object){
        rwlock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写入");
            map.put(key, object);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        } finally {
            rwlock.writeLock().unlock();
        }


    }

    public void get(String key){
        rwlock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写入");
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        } finally {
            rwlock.readLock().unlock();
        }



    }
}
