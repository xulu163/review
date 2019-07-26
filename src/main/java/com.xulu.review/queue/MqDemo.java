package com.xulu.review.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-05 18:11
 **/
public class MqDemo {

    private static final String url = "tcp://47.98.54.210:61616";

    private static final String queue_name = "queue_01";

    public void createProducer() throws Exception{
        //创建连接工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //创建连接
        Connection conn = factory.createConnection();
        conn.start();
        //创建会话
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地
        Queue queue = session.createQueue(queue_name);
        MessageProducer producer = session.createProducer(queue);
        for(int i = 0; i < 3; i ++){
            Message message = session.createTextMessage("hello world!");
            producer.send(message);
        }
        producer.close();
        session.close();
        conn.close();
    }

    public void createConsumer() throws Exception{
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        Connection conn = factory.createConnection();
        conn.start();
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(queue_name);
        MessageConsumer consumer = session.createConsumer(queue);
        while(true){
            TextMessage text = (TextMessage) consumer.receive();
            if(null != text){
                System.out.println("consumer1 text:" + text.getText());
            } else {
                break;
            }
        }
        consumer.close();
        session.close();
        conn.close();
    }

    public void createConsumerListen() throws Exception{
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        Connection conn = factory.createConnection();
        conn.start();
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(queue_name);
        MessageConsumer consumer = session.createConsumer(queue);

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if(null != message && message instanceof TextMessage){
                    TextMessage text = (TextMessage) message;
                    if(null != text){
                        try {
                            System.out.println("consumer2 text:" + text.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        System.in.read();
        consumer.close();
        session.close();
        conn.close();
    }
    public static void main(String[] args)  throws Exception{

        //new MqDemo().createProducer();
        new MqDemo().createConsumer();
        new MqDemo().createConsumerListen();

        Thread.sleep(1000L);
        new MqDemo().createProducer();

    }

    /**
     * 消息队列的使用场景？
     *  主要用于解决应用解耦、流量削锋、异步处理、最终一致性
     *  1）用户注册后，异步发送邮件、短信和站内信。可以提示系统的并发量
     *  2）用户下单成功调用库存系统减库存，可使用队列。因为如果下单时库存系统不可用，那会失败，
     *  如果使用队列，遇到库存系统不可用时不会出问题，库存系统重启后再消费消息完成库存扣减即可。
     *  3）流量削锋，比如秒杀活动，一般会因为流量过大，导致应用挂掉。为解决这个问题，可以在应用
     *  前端假如消息队列，控制活动人数，缓解短时间内高流量压垮应用。
     *  4）日志处理
     *  5）聊天室通讯
     */


    /**
     * 1.先生产，启动一号消费者，再启动二号消费者
     * 问题：二号消费者还能消费消息吗？
     * 不能
     *
     * 2.先启动两个消费者，再生产6条消息，请问：消费情况如何？
     * 一人一半，因为默认消息队列服务器自带负载均衡策略
     *
     */


    /**
     * 点对点消息传递的特点如下：
     * 1。每个消息只能有一个消费者，类似1对1的关系。好比个人快递自己领取自己的。
     * 2。消息的生产者和消费者之间没有时间上的相关性。无论消费者在生产者发送消息的
     * 时候是否处于运行状态，消费者都可以提取消息。好比我们发送短信，发送者发送后不
     * 见得接受者会立即收看。
     * 3。消息被消费以后队列中不会再存储，所以消费者不会消费到已经被消费掉的消息。
     */


    /**
     * mq面试题
     * activemq默认的端口如何修改？
     * 修改activemq.xml配置文件
     * 你生产上的连接协议如何设置的？使用tcp吗？
     * 可以使用nio协议，官网上说有比tcp更好的性能
     * 更牛逼的，可以使用auto + nio，可以支持多种协议随意切换
     *
     * activemq支持的通讯协议有：tcp、nio、udp、ssl、http(s)、vm
     *
     *
     */

    /**
     * 消息中间件的高级特性和大厂常考重点
     * 1。引入消息队列之后该如何保证其高可用性？
     * 2。异步投递Async Sends
     * 异步发送允许在失败的情况下有少量的数据丢失，那么问题来了，怎么保证不丢失呢？
     * 正确的异步发送方式是需要接受回调回执的。
     *
     * 3。延迟投递和定时投递
     *
     * 4。分发策略
     *
     * 5。ActiveMQ消息重试机制
     * 什么情况下会有重试？
     *  1）client用了事务且在session中调用了rollback（）；
     *  2）client用了事务且在调用commit之前关闭或者没有commit
     *  3）client在client
     *
     * 请说说消息重发时间间隔和重发次数？
     *  间隔1s，次数是6次
     *
     * 有毒消息Poison Ack谈谈你的理解？
     *  一个消息被重发超过默认的最大次数6次时，消费端会给mq发送一个 poison ack表示
     *  这个消息有毒，告诉broker不要再发了，这个时候broker会把这个消息放到死信队列中。
     *
     * 6。死信队列
     *  开发人员可以在死信队列中查看异常信息，进行人工干预。
     *  自动删除过期的消息！
     *  存放非持久的消息放入死信队列！
     *
     * 7。如何保证消息不被重复消费呢？幂等性问题你谈谈
     *  网络延迟传输中，会造成消息重试中，会造成重复消费。
     *  1。往数据库里插入一条id为主键的数据
     *  2。消费之前在redis查询一下有没有id插入的数据
     */
}
