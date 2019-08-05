package com.xulu.review.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xulu
 * @date 2019/5/10
 * @link https://github.com/xulu163
 */
public class ThreadPoolDemo {

    /**
     * 线程池的7大参数
     * 1.corePoolSize：核心线程数
     *   当创建了线程池的时候，线程池中没有任何线程，当有任务到来时会去创建线程执行任务，
     *   当执行任务的线程数大于核心线程数的时候，就会将后来的请求任务加入到阻塞队列中
     * 2.maxPoolSize：最大线程数
     *   当核心线程数量不足以执行请求时，也就是阻塞队列中有任务而核心线程来不及执行时，
     *   会创建更多的线程来执行，而创建的最大线程数量由这个参数控制
     * 3.keepAliveTime：空闲线程的保留时间
     * 4.TimeUnit：空闲线程的保留时间单位。
     * 5.workQueue：阻塞队列,
     * 6.ThreadFactory:线程工厂，用来创建线程
     * 7.RejectedExecutionHandler：队列已满，并且任务量大于最大线程的异常处理策略
     */

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool(5);//一池5个处理线程

        try{
            pool.execute(()->{

            });
        } catch (Exception e){
            e.printStackTrace();
        } finally {

        }
    }
}
