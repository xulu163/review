package com.xulu.review.oom;

import java.nio.ByteBuffer;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-05-11 20:24
 **/
public class DirectBufferMemoryDemo {

    /**
     * 故障现象：Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
     * 直接内存挂掉
     * 导致原因：写NIO程序经常使用byteBuffer来读取或者写入数据，这是一种基于通道与缓冲区的I/O方式
     * 它可以使用native函数库直接分配堆外内存，然后通过一个内存在java堆里面的DirectByteBuffer对象作为这快内存的引用进行操作
     * 这样能在一些场景种显著提高性能，因为避免了在java堆和native堆中来回复制数据
     *
     * ByteBuffer.allocate()是分配jvm堆内存，属于gc管辖范围，由于需要拷贝所以速度相对较慢
     *
     * ByteBuffer.allocateDirect()是分配oc本地内存，不属于gc管理范围，由于不需要内存拷贝所以数据相对较快。
     *
     * 淡如果不断分配本地内存，堆内存很少使用，那么jvm就不需要执行gc，DirectByteBuffer对象们就不会回收，
     * 这时候堆内存充足，但本地内存可能已经使用光了，再次尝试分配本地内存就会出现oom，那程序就直接崩了
     *
     * -Xms10m
     * -Xmx10m
     * -XX:+PrintGCDetails
     * -XX:MaxDirectMemorySize=5m
     */
    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect( 6 * 1024 * 1024);
    }
}
