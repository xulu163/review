package com.xulu.review.oom;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-05-11 20:24
 **/
public class UnableCreateNativeThreadDemo {

    /**
     * 故障现象：Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
     *
     * 高并发请求服务器时，经常出现如下一场
     * 准确的讲改native-thread异常与对应的平台有关
     *
     * 导致原因：
     * 1。你的应用创建了太多线程，一个应用进程创建多个线程，超过系统承载极限
     * 2。你的服务器并不允许你的应用程序创建这么多线程，linux系统默认允许单个进程创建的线程数为1024个，
     * 你的应用创建的线程数超过这个睡昂，就会报这个error
     *
     * 解决办法：
     * 1。想办法降低你应用程序创建线程的数量，分析以应用是否真的需要创建这么多线程，如果不是，改代码将线程降到最低
     * 2。对于有的应用，确实要创建很多线程，远超linux系统默认的1024个线程的限制，可以通过修改linux服务器配置，扩大linux默认限制
     * @param args
     */
    public static void main(String[] args){

        for (int i = 0; ; i++) {
            System.out.println("**********i=" + i);
            new Thread( ()->{
                try{
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (Exception e){
                    e.printStackTrace();
                }
            },""+i).start();

        }

    }
}
