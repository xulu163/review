package com.xulu.review.design.proxy.statik;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-22 15:31
 **/
public class StaticProxtDemo {

    public static void main(String[] args) {

        //创建目标对象
        TeacherDao target = new TeacherDao();

        //创建代理对象，同时将被代理对象传递给代理对象
        TeacherDaoProxy proxy = new TeacherDaoProxy(target);

        //通过代理对象调用对象的方法
        proxy.teach();
    }
}
