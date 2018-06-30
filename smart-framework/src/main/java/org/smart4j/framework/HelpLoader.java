package org.smart4j.framework;

import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ClassHelper;
import org.smart4j.framework.helper.IocHelper;
import org.smart4j.framework.utils.ClassUtil;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/28 14:51
 * @Description:加载相应的helper类
 */
public final class HelpLoader {
    public static void init(){
        Class<?>[] classList={
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                Controller.class
        };
        for(Class<?> cls:classList){
            ClassUtil.loadClass(cls.getName(),false);
        }
    }

}
