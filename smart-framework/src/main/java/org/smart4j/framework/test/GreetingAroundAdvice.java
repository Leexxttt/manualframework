package org.smart4j.framework.test;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;


/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/11 16:01
 * @Description:
 */
@Component
public class GreetingAroundAdvice implements MethodInterceptor {

    private void before() {
        System.out.println("Before");
    }


    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }

    private void after() {
        System.out.println("After");
    }
}
