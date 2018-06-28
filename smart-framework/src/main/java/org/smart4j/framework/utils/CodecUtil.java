package org.smart4j.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/28 17:58
 * @Description:
 */
public final class CodecUtil {
    private static final Logger LOGGER=LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 将url编码
     */
    public static String encodeURL(String source){
        String target="";
        try {
             target = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("url encode failure",e);
            e.printStackTrace();
        }
        return target;
    }

    /**
     * 将url解码
     */
    public static String decodeURL(String source){
        String target="";
        try {
            target = URLDecoder.decode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("url decode failure",e);
            e.printStackTrace();
        }
        return target;
    }
}
