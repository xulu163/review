package com.xulu.review.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) throws Exception{
        CyclicBarrier cy = new CyclicBarrier(7, ()->{
            System.out.println("收集完成");
        });

        for(int i = 1; i <= 7; i++){
            final int m = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t收集到第"+m+"个");
                try {
                    cy.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
