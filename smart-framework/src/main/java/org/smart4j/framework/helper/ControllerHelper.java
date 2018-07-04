package org.smart4j.framework.helper;

import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/28 14:27
 * @Description:
 */
public final class ControllerHelper {
    /**
     * 用来存放请求与处理器的映射关系
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        //获取所有的controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (!controllerClassSet.isEmpty()) {
            for (Class<?> cls : controllerClassSet) {
                //获取controller中定义的方法
                Method[] methods = cls.getDeclaredMethods();
                if (ArrayUtils.isNotEmpty(methods)) {
                    //遍历这些方法
                    for (Method method : methods) {
                        //判断当前方法是否带有Action注解
                        if (method.isAnnotationPresent(Action.class)) {
                            //获取这个Action注解中的内容
                            Action action = method.getAnnotation(Action.class);
                            //获取Action的value 也就是映射地址
                            String mapping = action.value();
                            //使用正则表达式来判断url是否符合规则
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
                                    //获取请求的方法
                                    String requestMethod = array[0];
                                    //获取请求的路径
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(cls, method);
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * 获取Handler
     */
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request=new Request(requestMethod,requestPath);
        Handler handler = ACTION_MAP.get(request);
        return handler;
    }
}