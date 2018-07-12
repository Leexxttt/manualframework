package org.smart4j.framework.test;

import org.springframework.stereotype.Component;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/3 11:07
 * @Description:
 */
@Component
public class GreetingImpl implements Greeting {
    public void sayHello() {
        //before();
        System.out.println("Hello:");
        //after();
        //故意抛出一个异常，看看异常是否能够被拦截到
        //throw new RuntimeException("ERROR");
    }
    public void goodMorning(){
        System.out.println("GoodMorning");
    }
    public void goodNight(){
        System.out.println("GoodNight");
    }

}
