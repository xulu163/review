package com.xulu.review.queue;


/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-08 15:37
 **/
public class BrokerDemo {

    /**
     * activeMq的broker：
     * 相当于一个activemq的服务器实例
     * 说白了，broker其实就是实现了用代码形式启动activemq，将mq嵌入到java代码中，以便随时启动，
     * 在用的时候再去启动这样能节省资源，也保证可靠性。
     *
     */
    public static void main(String[] args) throws Exception{
//        BrokerService brokerService = new BrokerService();
//        brokerService.setUseJmx(true);
//        brokerService.addConnector("tcp://localhost:61616");
//        brokerService.start();
    }
}
