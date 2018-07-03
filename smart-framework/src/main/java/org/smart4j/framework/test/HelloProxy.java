package org.smart4j.framework.test;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/3 10:33
 * @Description:
 */
public class HelloProxy implements Hello{
    private Hello hello;

    public HelloProxy() {
        this.hello = new HelloImpl();
    }

    public void say(String name) {
        before();
        hello.say(name);
        after();
    }
    private void before() {
        System.out.println("Before");
    }
    private void after() {
        System.out.println("After");
    }
}
