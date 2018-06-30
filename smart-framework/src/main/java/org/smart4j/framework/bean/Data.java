package org.smart4j.framework.bean;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/28 15:10
 * @Description:
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;
    public Data(Object model){
        this.model=model;
    }
    public Object getModel(){
        return model;
    }
}
