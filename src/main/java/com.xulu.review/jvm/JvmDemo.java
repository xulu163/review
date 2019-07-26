package com.xulu.review.jvm;

import java.nio.Buffer;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-09 21:34
 **/
public class JvmDemo {

    /**
     * 硬件--》操作系统--》java虚拟机
     */

    /**
     * java虚拟机即jvm
     *
     * jvm运行在操作系统之上
     *
     *
     * 编译---》加载---》执行
     *
     * （栈管运行，堆管存储）
     *
     *
     * 1。classLoader类加载器
     *      负责加载class文件，
     *
     * 2。native interface
     *
     * 3。方法区
     *      方法区是被所有线程共享，所有字段和方法字节码，以及一些特殊的方法如构造函数，
     *    接口代码也再次定义
     *
     *    实例变量存在与堆里面
     *
     * 4。pc寄存器，即程序计数器
     *      每个线程都有一个程序计数器，就是一个指针，指向方法区中的方法字节码，由执行引擎读取
     *      下一条指令，是一个非常小的内存空间，几乎可以忽略不计。
     *
     * 5。本地方法区
     *
     * 6。栈
     *      也叫栈内存，主管Java程序的运行，是在线程创建时创建，对于栈来说不存在垃圾回收问题，
     *      只要线程一介俗栈也就消亡，
     *    栈存储3类数据：栈操作、本地变量、栈帧数据
     */

    /**
     * 所谓jvm优化，就是优化堆内存！
     */


    /**
     * 线程的生命周期？
     *
     * 新生 ---》运行---》阻塞---》等待----》死亡
     */

    /**
     * 面试题：
     * 写出5个常见的java异常！
     * 1）java.lang.StackOverflowError  栈空间撑爆
     * 2）java.lang.OutOfmemoryError   堆空间撑爆
     *
     */



    public static void test(){
        test();
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);


        byte[] bytea = new byte[1*1024*1024*1424];
    }

    /**
     * 堆内存包含三个区块：新生区、养老区、永久区。
     *
     * 新生区是类的诞生、成长、消亡的区域，一个类在这里产生，应用，最后被垃圾回收器收集，结束生命。
     * 其中新生区又包含：伊甸区、幸存0区、幸存1区。所有的类都是在伊甸区被new出来的。当伊甸区的空间
     * 用完时，程序又需要创建对象，jvm的垃圾回收器将堆伊甸区进行垃圾回收，将伊甸区中不再被其他对象
     * 所引用的对象进行销毁。最后将伊甸区的剩余对象移动到幸存0区，若幸存0区也满了，再对该区进行垃圾
     * 回收，然后移动到幸存1区，如果幸存1区也满了，就移动到养老区。若养老区也满了，这个时候将产生
     * Major GC（FullGC），进行养老区的内存清理。若养老区执行了fullGC之后发现依然无法进行对象的
     * 保存，就会产生OOM。
     *
     * 如果出现java.lang.OutOfMemoryError:Java heap space异常，说明Java虚拟机的堆内存不够。
     * 原因有二：
     * 1）java虚拟机的堆内存设置不够，可以通过参数-Xms、-Xmx来调整
     * 2）代码中创建了大量的大对象，并且长时间不能垃圾回收（存在被应用所以不能回收）
     *
     */

    /**
     * 养老区：养老区用于保存从新生区筛选出来的java对象，一般池对象就在这个区域活跃。
     *
     *  数据库连接池就在养老区，养老区不会进行频繁的垃圾回收。
     */

    /**
     * 永久区：永久区是一个常驻内存区域，用于存放jdk自身所携带的class，interface的元数据，也就是说
     * 它村粗的是运行环境必须的类信息，被装载进次区域的数据是不会被垃圾回收器收掉的，关闭jvm才会释放
     * 此区域所占用的内存。
     *
     * 如果出现java.lang.OutOfMemoryError: PermGen space,说明是java虚拟机对永久区Perm内存设置
     * 不够。一般出现这种情况，都是程序启动需要加载大量的第三方jar包。
     *
     * jdk1.6及之前：有永久带，常量池1.6在方法区
     * jdk1.7:      有永久带，常量池1.7在堆
     * jdk1.8:      无永久带，常量池1.8在元空间（Metaspace）
     *
     *
     * java7与java8最大的区别，java8没有永久带
     */

    /**
     * 频繁收集young区 -- 普通gc（minor GC），采用的回收算法是复制算法
     * 较少收集old区   -- 全局gc（full GC），采用标记清除与标记整理混合实现
     * 基本不动perm区
     *
     * young区的对象被垃圾回收15次还没有回收就会被移动到old区
     */

    /**
     * gc回收算法：
     *
     *      复制算法：复制算法的基本思想就是将内存分为两块，每次只用其中一块，当
     *   一块用完了就将还活着的对象复制到另外一块内存上面，复制算法不会产生内存碎片，
     *   但是浪费了一点空间，因为要预留一半空间。
     *
     *      标记清除：从根集合开始扫描，对存活的对象进行标记，扫描整个内存空间，回收
     *   未被标记的对象。不需要额外空间所以比复制算法节约空间，但是会产生内存碎片，并且
     *   效率比较低，因为要扫两遍。
     *
     *      标记整理：标记-》清除-》整理，三部，唯一的缺点就是效率很慢。
     */


    /**
     * 我是来自某某大学，计算机专业毕业，7年开发经验，熟悉常用的开发框架，
     */
}
