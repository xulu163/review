package com.xulu.review.oom;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-05-11 20:06
 **/
public class StackOverFlowErrorDemo {

    public static void main(String[] args) {
        stackOverFlowError();
    }

    /**
     * 深度的方法调用导致栈干爆了
     */
    private static void stackOverFlowError() {
        stackOverFlowError();//Exception in thread "main" java.lang.StackOverflowError
    }
}
