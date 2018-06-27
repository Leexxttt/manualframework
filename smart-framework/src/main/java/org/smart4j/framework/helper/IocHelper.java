package org.smart4j.framework.helper;

import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/27 17:31
 * @Description:
 */
public final class IocHelper {
    static {
        //获取所有的bean
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if(!beanMap.isEmpty()){
            for(Class<?> cls:beanMap.keySet()){
                Object beanInstance = beanMap.get(cls);
                //获取Bean类定义的所有成员变量
                Field[] beanFields = cls.getDeclaredFields();
                if(ArrayUtils.isNotEmpty(beanFields)){
                    for(Field field:beanFields){
                        //判断当前变量是否带有Inject注解
                        if(field.isAnnotationPresent(Inject.class)){
                            //获取对应的实例
                            Class<?> beanFieldClass = field.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            //判断是否初始化过了
                            if(beanFieldInstance==null){
                                beanFieldInstance = ReflectionUtil.newInstance(beanFieldClass);
                            }
                            //将这个属性对象注入到目标对象中
                            ReflectionUtil.setField(beanInstance,field,beanFieldInstance);
                        }
                    }
                }
            }
        }
    }
}
