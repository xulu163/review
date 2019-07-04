package com.xulu.review.lock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 死锁问题
 *
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-05-11 16:56
 *
 * 死锁是指两个或两个以上的进程在执行过程中，
 * 因争夺资源而造成的一种互相等待的现象，
 * 若无外力干涉那他们都无法推进下去
 **/
public class DeadLockDemo {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static ThreadMXBean mbean = ManagementFactory.getThreadMXBean();

    public static void main(String[] args) {

        new Thread(){
            public void run(){
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName() + "get lock1,try to get lock2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println(Thread.currentThread().getName() + "get lock2");
                    }
                }
            }
        }.start();

        new Thread(){
            public void run(){
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName() + "get lock2,try to get lock1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println(Thread.currentThread().getName() + "get lock1");
                    }
                }
            }
        }.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long[] deadlockedThreads = mbean.findDeadlockedThreads();
        //遍历数组获取所有的死锁线程详细堆栈信息并打印
        for (long pid : deadlockedThreads) {
            //此方法获取不带有堆栈跟踪信息的线程数据
            //hreadInfo threadInfo = mbean.getThreadInfo(pid);
            //第二个参数指定转储多少项堆栈跟踪信息,设置为Integer.MAX_VALUE可以转储所有的堆栈跟踪信息
            ThreadInfo threadInfo = mbean.getThreadInfo(pid,Integer.MAX_VALUE);
            System.out.println(threadInfo);
        }
    }

    /**
     * 如何避免死锁？
     *  1。每个线程尽量按获取资源顺序加锁
     *  2。获得资源时加上时限，如果超过这个时限就放弃资源
     *  3。死锁检测：按线程间获取锁的关系检测线程间是否发生死锁，如果发生死锁就执行一定的策略，如：中断线程或回滚操作等。
     *
     */


    /**
     * 死锁检测
     * 1。Jconsole
     * 2。jstack
     *      jps命令查看java进程
     *      jstack -l pid 打印出锁的相关信息
     * 3。ThreadMXBean 代码级的死锁检测
     */
}


