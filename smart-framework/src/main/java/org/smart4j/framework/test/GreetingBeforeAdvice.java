package org.smart4j.framework.test;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/11 15:29
 * @Description: Greeting前置增强类
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before");
    }
}
