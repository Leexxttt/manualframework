package org.smart4j.framework.test;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/11 15:37
 * @Description:
 */
public class Client4 {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        //设置目标类对象
        proxyFactory.setTarget(new GreetingImpl());
        //设置前置后置增强
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        Greeting greeting = (Greeting)proxyFactory.getProxy();
        greeting.sayHello();
    }
}
