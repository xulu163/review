package com.xulu.review.demo;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-08-06 13:17
 **/
public class Demo {

    public static void main(String[] args) {
        IStu istu = new Stu();

        StuProxy stuProxy = new StuProxy(istu);

        stuProxy.study();
    }
}
