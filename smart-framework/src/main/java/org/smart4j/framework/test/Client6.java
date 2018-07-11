package org.smart4j.framework.test;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/11 17:32
 * @Description:
 */
public class Client6 {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        Greeting proxy = (Greeting)proxyFactory.getProxy();
        proxy.sayHello();
    }
}
