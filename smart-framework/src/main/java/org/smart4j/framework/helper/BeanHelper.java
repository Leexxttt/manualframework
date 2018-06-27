package org.smart4j.framework.helper;

import org.smart4j.framework.utils.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/27 17:15
 * @Description:
 */
public final class BeanHelper {
    /**
     * 用来存放Bean
     */
    private static final Map<Class<?>,Object> BEAN_MAP=new HashMap<Class<?>, Object>();


    static {
        //获取所有的Bean的class
        Set<Class<?>> beanClassSet=ClassHelper.getBeanClassSet();
        //创建class的实例
        for(Class<?> cls:beanClassSet){
            Object obj = ReflectionUtil.newInstance(cls);
            BEAN_MAP.put(cls,obj);
        }
    }
    /**
     * 获取所有的Bean映射
     */
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }
    /**
     * 获取Bean实例
     */
    public static <T> T getBean(Class<?> cls){
        if(!BEAN_MAP.containsKey(cls)){
            throw new RuntimeException("can not get bean by class"+cls);
        }else{
            return (T) BEAN_MAP.get(cls);
        }
    }
}
