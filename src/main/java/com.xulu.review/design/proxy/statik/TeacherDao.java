package com.xulu.review.design.proxy.statik;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-22 15:24
 **/
public class TeacherDao implements ITeacherDao {

    public void teach(){
        System.out.println("静态代理老师授课中。。。。");
    }
}
