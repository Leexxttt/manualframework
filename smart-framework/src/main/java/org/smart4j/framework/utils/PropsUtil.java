package org.smart4j.framework.utils;

import java.io.*;
import java.util.Properties;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/27 10:59
 * @Description:
 */
public final class PropsUtil {

    //根据路径读取properties文件
    public static Properties loadProps(String path) {
        InputStream in = null;
        Properties prop = null;
        try {
            in = new BufferedInputStream(new FileInputStream(
                    new File(path)));
            prop = new Properties();
            prop.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    //根据properties和key获取value
    public static String getString(Properties prop, String key) {
        return prop.getProperty(key);
    }
}
