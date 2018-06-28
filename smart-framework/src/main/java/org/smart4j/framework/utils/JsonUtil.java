package org.smart4j.framework.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/28 18:03
 * @Description:
 */
public final class JsonUtil {
    private static final Logger LOGGER=LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER=new ObjectMapper();

    /**
     * 将POJO转为json
     */
    public static <T> String toJson(T obj){
        String json="";
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
