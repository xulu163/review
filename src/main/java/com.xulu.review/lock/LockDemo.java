package com.xulu.review.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized和lock有什么区别? 新的lock有什么好处?
 * @author xulu
 * @date 2019/5/9
 * @link https://github.com/xulu163
 */
public class LockDemo {

    /**
     * 1.原始构成
     *  synchronized是关键字属于jvm层面
     *  Lock是具体类，是api层面的锁
     * 2.使用方法
     *  synchronized不需要手动去释放锁
     *  lock需要
     * 3.等待是否可中断
     *  synchronized不可中断，除非抛出异常或者正常运行完成
     *  lock可中断：
     * 4.加锁是否公平
     *  synchronized是非公平锁
     *  lock可以设置公平属性，都可以包含
     * 5.锁绑定多个条件
     *  synchronized没有
     *  lock用来实现分组唤醒需要唤醒的线程，可以精确唤醒，而不是像synchronized要么随机唤醒要么唤醒全部线程
     */



    /**
     * 题目：多线程之间按顺序调用，实现A-》B-》C三个线程启动，要求如下：
     * A打印5次，B打印10次，C打印15次
     * 紧接着
     * A打印5次，B打印10次，C打印15次
     * ......
     * 来10轮
     */
    /**
     * A:1,B:2,C:3
     */
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void print5(){
        lock.lock();
        try{
            while(number != 1){
                c1.await();
            }
            for (int i = 1; i <= 5; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 2;
            c2.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try{
            while(number != 2){
                c2.await();
            }
            for (int i = 1; i <= 10 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 3;
            c3.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try{
            while(number != 3){
                c3.await();
            }
            for (int i = 1; i <= 15 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 1;
            c1.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        LockDemo shareResource = new LockDemo();

        new Thread(() ->{
            for (int i = 1; i <= 10; i++) {
                shareResource.print5();
            }
        },"A").start();

        new Thread(() ->{
            for (int i = 1; i <= 10; i++) {
                shareResource.print10();
            }
        },"B").start();

        new Thread(() ->{
            for (int i = 1; i <= 10; i++) {
                shareResource.print15();
            }
        },"C").start();
    }

}
