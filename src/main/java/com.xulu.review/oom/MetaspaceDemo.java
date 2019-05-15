package com.xulu.review.oom;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-05-11 20:25
 **/
public class MetaspaceDemo {

    static class OOMTset{}
    public static void main(String[] args) {
        int i = 0;
        try{
            while (true){
                i++;
                new OOMTset();
            }
        }catch (Throwable e){
            System.out.println("*********第多少次后发生了异常：" + i);
            e.printStackTrace();
        }
    }
}
