package com.xulu.review.queue;

/**
 * topic模式
 *
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-08 11:10
 **/
public class MqTopic {

    /**
     * 扫帚不到，灰层不会自己跑掉
     */

    /**
     *发布/订阅消息传递的特点如下：
     * 1。生产者将消息发布到topic中，每个消息可以有多个消费者，属于1：N的关系
     * 2。生产者和消费者之间有时间上的相关性。订阅某一个主题的消费者只能消费自
     * 他订阅之后发布的消息。
     * 3。生产者生产时，topic不保存消息他是无状态的不落地，假如无人订阅就去生产
     * 那就是一条废消息，所以，一般先启动消费者再启动生产者。
     *
     * JMS规范允许客户创建持久订阅，这在一定层度上放松了时间上的相关性要求。持久
     * 订阅允许消费者消费他在未处于激活状态时发送的消息。一句话，好比我们的微信公
     * 众号的订阅
     */

    public static void main(String[] args) {
        Integer flag = 2;
        switch (flag){
            case 3 :
                System.out.println("fuck");
            case 4 :
                System.out.println("you");
            default:
                System.out.println("!");
        }
    }
}
