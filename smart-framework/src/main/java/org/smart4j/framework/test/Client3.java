package org.smart4j.framework.test;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/11 15:30
 * @Description:
 */
public class Client3 {
    public static void main(String[] args) {
        //创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        //摄入目标类对象
        proxyFactory.setTarget(new GreetingImpl());
        //添加前置增强
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        //添加后置增强
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        //从代理工厂中获取代理
        Greeting greeting =(Greeting) proxyFactory.getProxy();
        greeting.sayHello();
    }
}
