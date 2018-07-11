package org.smart4j.framework.test;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/3 11:09
 * @Description:
 */
public class GreetingProxy implements Greeting {
    private GreetingImpl greetingImpl;

    public GreetingProxy(GreetingImpl greetingImpl) {
        this.greetingImpl = greetingImpl;
    }

    public void sayHello() {
        before();
        greetingImpl.sayHello();
        after();
    }

    private void after() {
        System.out.println("After");
    }

    private void before() {
        System.out.println("Before");
    }
}
