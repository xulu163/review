package com.xulu.review.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author xulu
 * @date 2019/5/10
 * @link https://github.com/xulu163
 */
public class ThreadDemo {

    public static void main(String[] args) throws Exception{
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());

        new Thread(futureTask, "AA").start();
        new Thread(futureTask, "BB").start();
        //现在有两个线程，一个main主线程，一个AA线程

        //要求获得AA线程的计算结果，如果没有计算完成就要去强求
        int result2 = 222;

        while(!futureTask.isDone()){

        }
        int result1 = futureTask.get();
        System.out.println("*****result:"+(result1 + result2));
    }
}

class MyThread implements Callable<Integer>{

    /**
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception{
        System.out.println("第三种方式实现线程创建");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}
