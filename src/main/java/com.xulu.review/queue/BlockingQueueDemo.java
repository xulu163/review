package com.xulu.review.queue;

import com.sun.deploy.util.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 阻塞队列
 *
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-05-09 12:26
 **/
public class BlockingQueueDemo {

    /**
     * 1 队列
     * 2 阻塞队列
     *  2.1阻塞队列有没有好的一面
     *  2.2不得不阻塞，你如何管理
     */

    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(10));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consume").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5秒到，叫停");
        try {
            myResource.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class MyResource{

    /**
     * 默认开启生产+消费
     */
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while (flag){
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列" + data +"成功");
            } else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列" + data +"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停，生产动作结束");
    }

    public void myConsumer() throws Exception{
        String data = null;
        while (flag){
            data = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(null == data || "".equals(data)){
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t 超时2秒未渠道值，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列" + data +"成功");
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void stop() throws Exception {
        this.flag = false;
    }
}
