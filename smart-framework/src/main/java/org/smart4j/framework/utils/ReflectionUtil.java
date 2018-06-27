package org.smart4j.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/27 14:32
 * @Description:
 */
public final class ReflectionUtil {

    private static final Logger LOGGER=LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     */
    public static Object newInstance(Class<?> cls){
        Object instance=null;
        try {
            instance  = cls.newInstance();
        } catch (Exception e) {
            LOGGER.error("new instance failure",e);
            e.printStackTrace();
        }
        return instance;
    }
    /**
     * 方法的调用
     */
    public static Object invokeMethod(Object obj, Method method,Object...args){

    }

}
