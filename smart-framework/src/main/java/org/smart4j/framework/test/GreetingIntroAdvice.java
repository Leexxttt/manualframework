package org.smart4j.framework.test;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/11 17:45
 * @Description:
 */
@Component
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology{
    public void saySorry(String name) {
        System.out.println("Sorry!"+name);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }
}
