package org.smart4j.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/28 17:50
 * @Description:
 */
public final class StreamUtil {
    private static final Logger LOGGER=LoggerFactory.getLogger(StreamUtil.class);

    /**
     * 将流转为字符串
     */
    public static String getString(InputStream is){
        StringBuilder sb=new StringBuilder();
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line=bufferedReader.readLine())!=null){
                sb.append(line);
            }
        }catch (IOException e){
            LOGGER.error("stream read failure");
        }
        return sb.toString();
    }

}
