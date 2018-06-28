package org.smart4j.framework.bean;

import java.util.Map;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/28 15:01
 * @Description:
 */
public class Param {
    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }
    /**
     * 获取所有字段信息
     */
    public Map<String,Object> getMap(){
        return paramMap;
    }
}
