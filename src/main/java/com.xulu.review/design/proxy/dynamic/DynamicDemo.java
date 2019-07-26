package com.xulu.review.design.proxy.dynamic;

import com.xulu.review.design.proxy.CglibTeacherDao;
import com.xulu.review.design.proxy.ITeacherDao;
import com.xulu.review.design.proxy.TeacherDao;

/**
 * 动态代理
 *
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-22 13:52
 **/
public class DynamicDemo {

    public static void main(String[] args) {

        /**
         * 动态代理是动态产生的代理对象，当代理对象方法扩展时不需要新增代理方法
         */
//        ITeacherDao targer = new TeacherDao();
//
//        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(targer).getProxyInstance();
//
//        proxyInstance.teacher();


        //下面是cglib代理

        CglibTeacherDao cglibTeacherDao = new CglibTeacherDao();
        CglibTeacherDao instance = (CglibTeacherDao)new CglibProxyFactory(cglibTeacherDao).getCglibProxyInstance();
        instance.teacher();
    }

}
