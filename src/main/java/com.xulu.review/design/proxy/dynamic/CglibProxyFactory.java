package com.xulu.review.design.proxy.dynamic;



import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理
 *
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-22 14:57
 **/
public class CglibProxyFactory implements MethodInterceptor {

    private Object target;

    public CglibProxyFactory(Object target){
        this.target = target;
    }

    //返回一个代理对象
    public Object getCglibProxyInstance(){
        //1.创建一个工具类
        Enhancer enhancer = new Enhancer();
        //2。设置父类
        enhancer.setSuperclass(target.getClass());
        //3。设置回调函数
        enhancer.setCallback(this);
        //4。创建子类对象，即代理对象
        return enhancer.create();
    }

    /**
     * 维护一个目标对象
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("cglib代理模式开始");
        Object obj = method.invoke(target, objects);
        System.out.println("cglib代理提交");
        return obj;
    }
}
