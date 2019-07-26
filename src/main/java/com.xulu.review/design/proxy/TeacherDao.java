package com.xulu.review.design.proxy;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-22 13:50
 **/
public class TeacherDao implements ITeacherDao {

    public void teacher(){
        System.out.println("老师授课中。。。");
    }
}
