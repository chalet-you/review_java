package com.itheima._10Properties属性集对象;

import java.io.InputStream;
import java.util.Properties;

/**
    目标：项目上用Properties读取属性文件中的键值对信息。（读取）
    Properties的方法：
        -- public Object setProperty(String key, String value) ： 保存一对属性。
        -- public String getProperty(String key) ：使用此属性列表中指定的键搜索属性值
        -- public Set<String> stringPropertyNames() ：所有键的名称的集合
        -- public void store(OutputStream out, String comments):保存数据到属性文件中去
        -- public synchronized void load(InputStream inStream):加载属性文件的数据到属性集对象中去
        -- public synchronized void load(Reader fr):加载属性文件的数据到属性集对象中去
    小结：
        属性集对象可以加载读取属性文件中的数据！
 */
public class PropertiesDemo03 {
    public static void main(String[] args) throws Exception {
        // 1.使用ClassLoader加载属性文件为InputStream，自动识别带 .properties后缀的文件
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("users.properties");
        // 2.创建一个属性集对象
        Properties properties = new Properties();

        // 3.字节输入流加载属性文件的数据到属性集对象properties中去。
        properties.load(is);

        // 4.获取对应属性key的value值

        String value1 = properties.getProperty("dlei");
        String value2 = properties.getProperty("admin");

    }
}
