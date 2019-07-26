package com.xulu.review.nio;

import java.nio.Buffer;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-10 09:36
 **/
public class NioDemo {


    /**
     * nio（new io），也叫non blocking io，即非阻塞io
     *
     * 用于解决大并发量的io操作
     */

    /**
     * 传统io：面向数据流，是单向的
     * nio：面向缓冲区，完成数据传输，通道只负责连接
     *
     * java Nio系统的核心在于：通道channel和缓冲区buffer。通道表示打开到IO设备的连接，
     * 若需要使用nio系统，需要获取用于连接io设备的通道以及用于容纳数据的缓冲区。然后操作缓冲区，
     * 对数据进行处理。缓冲区就是数组，用于存储不同类型的数据。
     */

    public static void main(String[] args) {

        /**
         * Buffer的四个核心属性：
         *     mark：标记，表示记录当前position的位置。
         *     position：
         *     limit：界限，
         *     capacity：容量，表示缓冲区最大存储数据的容量。一旦声明不能改变
         */
    }

    /**
     * 阻塞与非阻塞
     *
     */

}
