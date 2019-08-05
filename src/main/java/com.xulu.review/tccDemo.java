package com.xulu.review;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-09 21:10
 **/
public class tccDemo {

    /**
     * 事务：多次数据库的操作，要么同时成功，要么同时失败的机制就是事务！
     *
     * 分布式事务：在分布式系统中保证事务性。
     *
     *
     * 创建连接
     *
     * 开启事务
     *
     * 执行方法
     *
     * 提交/回滚
     *
     */


    /**
     * 订单服务 --- 库存服务
     *
     *
     */

    public static void main(String[] args) {
        Integer a = 5 ;
        Integer b = 400;
        System.out.println((a > b));
    }
}
