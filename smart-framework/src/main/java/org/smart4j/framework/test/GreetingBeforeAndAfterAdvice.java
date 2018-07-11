package org.smart4j.framework.test;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/11 15:35
 * @Description:
 */
public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice,AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After");
    }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before");
    }
}
