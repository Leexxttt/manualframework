package org.smart4j.framework.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;


/**
 * @AUTHOR: lxt
 * @DATE: 2018/6/27 11:37
 * @Description:
 */
public final class ClassUtil {

    private static final Logger LOGGER=LoggerFactory.getLogger(ClassUtil.class);

    /**
     * 获取类加载器
     */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }
    /**
     * 加载类
     */
    public static Class<?> loadClass(String className,boolean isInitialized){
        Class<?> cls=null;
        try {
            cls = Class.forName(className, isInitialized, getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cls;
    }
    /**
     * 获取指定包名下的所有类
     */
    public static Set<Class<?>> getCLassSet(String packageName){
       Set<Class<?>> classSet=new HashSet<Class<?>>();

       //解析包路径
        try {
            Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".", "/"));
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                if(url!=null){
                    //获取这个url对应的协议
                    String protocol = url.getProtocol();
                    if(protocol.equals("file")){
                        //去除url中的空格
                        String packagePath = url.getPath().replaceAll("%20", "");
                        addClass(classSet,packagePath,packageName);
                    }
                }
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
        return classSet;
    }
    public static void addClass(Set<Class<?>> classSet,String packagePath,String packageName){
        File[] files=new File(packagePath).listFiles(new FileFilter() {
            public boolean accept(File file) {

                return (file.isFile()&&file.getName().endsWith(".class")||file.isDirectory());
            }
        });
        for(File file:files){
            String fileName=file.getName();
            if(file.isFile()){
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                if(StringUtils.isNotEmpty(packageName)){
                    className=packageName+"."+className;
                }
                doAddClass(classSet,className);
            }else{
                //这是一个目录，所以文件名就是路径
                String subPackagePath=fileName;
                if(StringUtils.isNotEmpty(packagePath)){
                    subPackagePath=packagePath+"."+subPackagePath;//加上现在的包路径得到一个新的包路径
                }
                String subPackageName=fileName;
                if(StringUtils.isNotEmpty(packageName)){
                    subPackageName=packageName+"."+subPackageName;
                }
                //目录递归重新遍历
                addClass(classSet,subPackagePath,subPackageName);
            }
        }
    }
    public static void doAddClass(Set<Class<?>> classSet,String className){
        //使用类加载器加载指定类名的类
        Class<?> aClass = loadClass(className, false);
        classSet.add(aClass);
    }

}
