package org.smart4j.framework.test;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/3 11:07
 * @Description:
 */
public class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        //before();
        System.out.println("Hello:"+name);
        //after();
    }
    public void goodMorning(String name){
        System.out.println("GoodMorning:"+name);
    }
    public void goodNight(String name){
        System.out.println("GoodNight:"+name);
    }

    private void after() {
        System.out.println("After");
    }

    private void before() {
        System.out.println("Before");
    }
}
