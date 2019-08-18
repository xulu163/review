package com.xulu.review.demo;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-08-06 13:12
 **/
public class StuProxy {

    private IStu iStu;

    public StuProxy(IStu iStu){
        this.iStu = iStu;
    }

    public void study(){
        iStu.study();
    }
}
