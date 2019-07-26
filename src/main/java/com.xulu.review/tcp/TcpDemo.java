package com.xulu.review.tcp;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-19 10:11
 **/
public class TcpDemo {

    /**
     * 1。描述一下tcp三次握手的过程：
     *
     * 1）客户端向服务端发送一个syn（seq=x）包到服务器，并进入syn_send状态，等待服务器确认；
     * 2）服务端收到syn包，会进行确认回一个ack=x+1包，并且还会回复一个syn（seq=y）；此时服务器进入syn_recv状态；
     * 3）客户端收到服务器的syn+ack包，向服务器发送确认包ack（ack=y+1），此时发送完毕，客户端和服务器进入established状态，完成三次握手
     * 握手过程中传送的包里不包含数据，三次握手完毕后，客户端与服务器才正式开始传送数据。
     * 理想状态下，tcp连接一旦建立，在通信双方中的任何一方主动关闭连接之前，tcp连接都将一直保持下去。
     *
     * 2。为什么需要三次握手？
     *
     *    如果一个连接请求在网络中跑得慢，超时了，这时客户端会重发请求，但是这个跑得慢的请求
     * 最后还是跑到了，然后服务端就接受了两个连接请求，然后全部回应就会创建两个连接，浪费资源！
     * 如果加了第三次客户端确认，客户端在接受到一个服务端连接确认请求后，后面再接收到的连接确认请求就可以抛弃不管了。
     *
     */

    /**
     * 3。四次挥手断开连接的过程：
     *
     * 1）主动关闭方发送一个FIN，用来关闭主动方到被动关闭方的数据传送，也就是主动方告诉被动方：我已经不会再给你发送数据了
     * 2）被动关闭方收到FIN包后，发送一个ack给对方，确认序号为收到序号+1（与syn相同，一个FIN占用一个序号）
     * 3）被动方发送一个FIN，用来关闭被动关闭方到主动关闭方的数据传送，也就是告诉主动关闭方，我的数据也发送完了，不会再给你发数据了；
     * 4）主动关闭方收到FIN后，发送一个ack给被动关闭方，确认序号为收到序号+1，至此，完成四次挥手。
     *
     *
     * 4。为什么需要四次挥手断开连接？
     *
     *    因为tcp是双向的，所以需要在两个方向分别关闭，每个方向的关闭又需要请求和确认，所以四次。
     */

    /**
     * 5。HTTP协议与TCP协议的区别？
     */
}
