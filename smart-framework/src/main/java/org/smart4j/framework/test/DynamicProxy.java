package org.smart4j.framework.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/3 10:38
 * @Description:
 */
public class DynamicProxy implements InvocationHandler {
    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(object, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }
}

