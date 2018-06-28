package org.smart4j.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/28 15:03
 * @Description:
 */
public class View {
    /**
     * 视图路径
     */
    private String path;
    /**
     * 模型数据
     */
    private Map<String,Object> model;
    public View(String path){
        this.path=path;
        model=new HashMap<String, Object>();
    }

    /**
     * 添加数据
     * @param key
     * @param value
     * @return
     */
    public View addModel(String key,Object value){
        model.put(key,value);
        return this;
    }
    /**
     * 获取路径
     */
    public String getPath(){
        return path;
    }
    /**
     * 获取数据
     */
    public Map<String,Object> getModel(){
        return model;
    }
}
