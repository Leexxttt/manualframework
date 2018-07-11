package org.smart4j.framework.test;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/11 17:38
 * @Description:
 */
public class GreetingThrowAdvice implements ThrowsAdvice {
    public void afterThrowing(Method method,Object[] args,Object target,Exception e){
        System.out.println("-----------EXCEPTION-----------");
        System.out.println("-------------------------------");
    }
}
