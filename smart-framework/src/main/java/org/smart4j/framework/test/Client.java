package org.smart4j.framework.test;

import java.lang.reflect.Proxy;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/3 10:36
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 静态代理
         */
//        Hello helloProxy=new HelloProxy();
//        helloProxy.say("lxt");

        /**
         * JDK自带的动态代理
         */
       /* Hello hello=new HelloImpl();
        DynamicProxy dynamicProxy=new DynamicProxy(hello);
        Hello helloProxy = (Hello)Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), dynamicProxy);
        helloProxy.say("lxt");*/

        /**
         * CGLib动态代理(与JDK不同的是不需要接口)
         */
        CGLibProxy cgLibProxy=new CGLibProxy();
        Hello helloProxy = cgLibProxy.getProxy(HelloImpl.class);
        helloProxy.say("lxt");

    }
}
