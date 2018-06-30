package org.smart4j.framework.helper;

import java.lang.reflect.Method;
import java.util.Set;

public class ControllerHelper {

    static {
        //获取所有的Controller类
        Set<Class<?>> controllerClassSet= ClassHelper.getControllerClassSet();
        if(!controllerClassSet.isEmpty()){
            //遍历controller
            for(Class<?> cls:controllerClassSet){
                //获取这个controller的所有方法
                Method[] declaredMethods = cls.getDeclaredMethods();
            }
        }
    }
}
