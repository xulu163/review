package com.xulu.review.lock;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch:闭锁，在完成某些运算时，只有其他所有线程的运算全部完成时，当前运算才能继续进行
 * @author xulu
 * @date 2019/5/15
 * @link https://github.com/xulu163
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(5);

    }

}

class LatchDemo implements Runnable{

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        try{
            for(int i = 0; i < 50000; i++){
                if(i % 2 == 0){
                    System.out.println();
                }
            }
        }finally {
            latch.countDown();
        }
    }
}
