package org.smart4j.framework.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/3 11:56
 * @Description:
 */
@Aspect
@Component
public class GreetingAspect {

    /**
     * 第一个*表示方法的返回值是任意的
     * 第二个*表示匹配类中的所有方法
     * (..)表示方法的参数是任意的
     *
     */
   @Around("execution(* org.smart4j.framework.test.GreetingImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
       before();
       Object result = pjp.proceed();
       after();
       return result;
   }

    private void after() {
        System.out.println("After");
    }

    private void before() {
        System.out.println("Before");
    }
}
