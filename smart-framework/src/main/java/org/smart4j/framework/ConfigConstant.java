package org.smart4j.framework;

/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/27 10:46
 * @Description:
 */
public interface ConfigConstant {
    String CONFIG_FILE="smart.properties";

    //driver
    String JDBC_DRIVER="smart.framework.jdbc.driver";
    //URL
    String JDBC_URL="smart.framework.jdbc.url";
    //username
    String JDBC_USERNAME="smart.framework.jdbc.username";
    //password
    String JDBC_PASSWORD="smart.framework.jdbc.password";

    //扫描的包
    String APP_BASE_PACKAGE="smart.framework.app.base_package";
    //jsp文件位置
    String APP_JSP_PATH="smart.framework.app.jsp_path";
    //asset文件
    String APP_ASSET_PATH="smart.framework.app.asset_path";
}
