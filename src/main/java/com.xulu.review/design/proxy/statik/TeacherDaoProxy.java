package com.xulu.review.design.proxy.statik;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-22 15:25
 **/
public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target){
        this.target = target;
    }

    public void teach(){

        System.out.println("代理开始");
        target.teach();
        System.out.println("代理结束");
    }

}
