package com.xulu.review.demo;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-08-06 13:06
 **/
public class SingleTon {

    private static volatile SingleTon singleTon;

    private SingleTon(){
        System.out.println("demo-----");
    }

    public static SingleTon getSingleTon(){
        if(null == singleTon){
            synchronized (SingleTon.class){
                if(null == singleTon){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

    public static void main(String[] args) {
        new Thread(()->{
            for(int i = 0; i < 100; i ++){
                SingleTon.getSingleTon();
            }
        }).start();
    }
}
