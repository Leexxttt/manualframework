package org.smart4j.framework.test;


import org.springframework.aop.framework.ProxyFactory;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/3 11:28
 * @Description:
 */
public class Client2 {
    public static void main(String[] args) {
        /**
         * 创建代理工厂
         */
        ProxyFactory proxyFactory=new ProxyFactory();
        /**
         * 射入目标类对象
         */
        proxyFactory.setTarget(new GreetingImpl());
        /**
         * 添加前置增强
         */
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        /**
         * 添加后置增强
         */
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        /**
         * 从代理工厂中获取代理
         */
        Greeting proxy = (Greeting)proxyFactory.getProxy();
        /**
         * 调用代理的方法
         */
        proxy.sayHello();
    }
}
