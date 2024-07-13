package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._01单例设计模式Singleton之饿汉式_方式1_静态变量方式;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description:
 *      饿汉式： 静态成员变量
 * @Author: 黑马程序员
 */
public class Singleton {

    //2，在本类中创建本类对象
    private static Singleton instance = new Singleton();

    //1，私有构造方法
    private Singleton() {}

    //3，提供一个公共的访问方式，让外界获取该对象
    public static Singleton getInstance() {
        return instance;
    }
}
