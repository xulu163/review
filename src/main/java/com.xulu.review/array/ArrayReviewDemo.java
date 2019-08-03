package com.xulu.review.array;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类练习
 */
public class ArrayReviewDemo {

    /**
     * boolean：1个字节
     * int：4个字节
     * float：4个字节
     * double：8个字节
     * char：2个字节
     * byte：1个字节
     * short：2个字节
     * long：8个字节
     */

    /**
     * ==和equals的区别
     *
     * 基本数据类型==比较的是值，引用数据类型==比较的是地址
     *
     * equals用来比较两个对象长得是否一样。
     *
     * 简单来说，equals比较的是两个数值是否相等；而==比较的是值的地址是否相等。
     */
//    public static void main(String[] args) {
//        String aa = new String("abc");
//        String bb = new String("abc");
//
//        String cc = "abc";
//        String dd = "abc";
//
//        System.out.println(aa.equals(bb));//true
//        System.out.println(aa == bb);     //false
//        System.out.println(cc == dd);     //true
//        System.out.println(cc.equals(bb));//true
//    }

    /**
     * String、StringBuilder、StringBuffer的区别？
     * String是内容不可变的字符串，因为String底层使用了final char[]；
     * StringBuilder、StringBuffer是内容可变的字符串,StringBuilder、
     * StringBuffer底层使用了可变的char[],可以使用append()进行数据
     * 修改。
     *
     * StringBuilder是线程不安全的，效率较高；StringBuffer是线程安全的，效率较低。
     *
     *
     *
     */


    /**
     * java中的集合
     *
     * 集合分为值（Collection），k-v（Map）
     *
     * 值存储的分为List和Set
     *   List接口是有序的，可以重复的
     *   Set是无序的，不可以重复的。
     *   重复与否根据equals和hashcode判断，也就是如果一个对象要存储在set中，必须重写equals
     *   和hashcode方法。
     *
     * 存储K-v的为Map
     */


    /**
     * ArrayList和LinkedList的区别？
     * List常用的实现类ArrayList和LinkedList，arrayList底层使用数组，linkedList底层使用
     * 的是链表。
     *
     * 数组的优点是查询非常快，插入、删除和修改比较慢（数组在内存中是连续，如果插入或删除是需要
     * 移动内存的）；
     *
     * 链表不要求内存地址是连续的，在当前元素中存放下一个或上一个元素的地址。查询时需要从头部开始
     * 一个一个的找，查询效率低。而插入时不需要移动内存，只需要改变引用指向即可。所以插入或者删除
     * 的效率高。
     *
     * arrayList使用在查询比较多，但是插入和删除比较少的情况；而linkedList使用在查询比较少而
     * 插入和删除比较多的情况。
     */

    /**
     * hashMap和hashTable的区别？
     *
     * 他们都可以存储k-v的数据。
     *
     * hashMap是可以把null作为k或者v的，而hashTable是不可以的；hashMap是线程不安全的，
     * hashTable是线程安全的，效率比较低。
     */

    /**
     * 有没有使用过线程并发库。
     */

    /**
     * 线程池的作用？
     * 1。限定线程的个数，不会导致由于线程过多致使系统运行缓慢或崩溃；
     * 2。线程池不需要每次都去创建或销毁，节约了资源，响应时间时间更快。
     *
     */

    /**
     * 常用的设计模式？
     * 1。设计模式是经过前人无数次的实践总结出的，设计过程中可以反复使用的、
     * 可以解决特定问题的设计方法。
     * 2。单例模式：
     *    工厂模式：spring的ioc就是使用的工厂模式
     *       对象的创建交给一个专门的工厂方法去创建，自己不用手动创建。
     *    代理模式：spring的aop就是使用的代理模式
     *    包装模式：
     */


    /**
     * get和post的区别？
     *
     * get和post都是http的请求方式，用户通过不同的http请求方式完成对资源
     * 的不同操作。get、post、put、delete对应着对资源的查询、新增、修改、删除
     * 4个操作，具体来讲get一般用于获取资源，而post一般用于新增资源。
     *
     * get请求提交的数据会在地址栏显示出来，而post请求不会在地址栏显示出来。
     * 在安全性上post更高。
     *
     */


    /**
     *
     * @param args
     */
//    public static void main(String[] args){
//
//        List<String> list = new CopyOnWriteArrayList(); //Collections.synchronizedList(new ArrayList());
//
//        for(int i = 1; i < 30; i++){
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0,8));
//                System.out.println(list);
//            }, String.valueOf(i)).start();
//        }
//
//    }

    /**
     * ArrayList是线程不安全的，Vector是线程安全的
     *
     * 1.故障现象：java.util.ConcurrentModificationException
     *
     * 2.导致原因：并发争抢修改导致
     *
     * 3.解决方案：
     *      3.1使用Vector
     *      3.2使用Collections工具类
     *      3.3使用CopyOnWriteArrayList,俗称写时复制
     *
     * 4.优化建议：
     */

    /**
     * copyOnWrite即写时复制，往容器添加元素的时候，不直接往当前容器添加，而是先将当前
     * 容器进行复制，然后往新的容器里添加元素，添加后再将愿容器的引用指向新的容器，这样的
     * 好处是可以对copyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元
     * 素，所以copyOnWrite容器也是一种读写分离的思想，读和写不同的容器。
     */

    /**
     * HashMap为什么不是线程安全的？
     *
     * hashmap线程不安全，在多线程的情况下，可能会造成数据丢失的问题，
     * 因为可能有俩个线程同时put,他的hash值会出现一致的情况，造成覆盖问题，从而导致数据丢失。
     *
     */

    /**
     * 1.常用集合和常用方法？
     *
     *
     * 2.Arraylist和LinkedList的区别？
     *  arrayList是组数实现的，它的查询效率更高而插入和删除效率低；linkedList是链表实现的，它
     * 的插入和删除效率高而查询效率低。
     *
     * 3.Arraylist是否会越界？
     * 可能会越界，在多线程操作同一个ArrayList的时候，两个线程同时执行Add在线程1已经将size++；
     * 而线程二在读取的时候导致越界 线程在被挂起的时候，执行的位置不一样；
     * Size是个共有变量 自增是个非原子操作。
     *
     * 4.hashmap的容量为什么是2的n次幂，
     * 最后让我解释一下treeMap。
     */

    /**
     * 直奔主题不废话，面试问题都是实现原理、内部机制、偏底层的，
     * 主要考察的数据库优化、缓存、高并发、linux这些问题，
     * 还有nginx的一些问题，很多东西回答出来之后会有更深入的挖掘，
     * 最好准备再去，不然会死的很难看，我就是例子，只知其一不知其二。
     *
     * nginx守护线程啥的。
     *
     * 垃圾回收机制、redis、数据库隔离级别、nginx
     * MySQL索引数据结构，zookeeper通讯协议
     *
     * 比如一些排序算法数据结构，java并发包里面的一些类，
     * 实现原理，然后会问你运维方面，故障排查等等，没有项目经历
     *
     * Redis的原子性？什么是原子操作？
     * 答原子性（atomicity）:一个事务是一个不可分割的最小工作单位,要么都成功要么都失败。
     * 原子操作是指你的一个业务逻辑必须是不可拆分的.
     * 比如你给别人转钱,你的账号扣钱,别人的账号增加钱,这个业务逻辑就是原子性的,这个操作就是原子操作,
     * 要么都成功要么都失败。
     *
     *
     * 从集群、负载均衡、数据库、线程池、缓存机制等方面了解高并发web应用的解决方案
     *
     */
}
