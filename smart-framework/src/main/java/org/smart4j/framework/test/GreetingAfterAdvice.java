package org.smart4j.framework.test;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/3 11:27
 * @Description:
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After");
    }
}
