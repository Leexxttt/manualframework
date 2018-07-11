package org.smart4j.framework.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/11 16:13
 * @Description:
 */
public class Client5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GreetingImpl greetingProxy = (GreetingImpl) context.getBean("greetingProxy");
        greetingProxy.sayHello();
    }
}
