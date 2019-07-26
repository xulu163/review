package com.xulu.review.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-22 13:53
 **/
public class ProxyFactory {

    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    //给目标对象生成一个代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("jdk代理开始");
                        Object obj = method.invoke(target, args);
                        System.out.println("jdk代理提交");
                        return obj;
                    }
                });
    }
}
