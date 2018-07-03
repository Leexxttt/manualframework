package org.smart4j.framework.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/7/3 11:13
 * @Description:
 */
public class CGLibDynamicProxy implements MethodInterceptor {
    /**
     * 将CGLib代理做成单例模式
     */
    private static CGLibDynamicProxy instance=new CGLibDynamicProxy();
    private CGLibDynamicProxy(){}
    public static CGLibDynamicProxy getInstance(){
        return instance;
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }
    /**
     * 获取代理目标对象
     */
    public <T> T getProxy(Class<T> cls){
        return (T)Enhancer.create(cls,this);
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
