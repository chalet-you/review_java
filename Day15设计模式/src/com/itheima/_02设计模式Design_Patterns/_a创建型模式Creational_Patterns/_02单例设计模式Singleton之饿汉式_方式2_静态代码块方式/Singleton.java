package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._02单例设计模式Singleton之饿汉式_方式2_静态代码块方式;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description:
 *
 *      饿汉式 ： 静态代码块
 * @Author: 黑马程序员
 */
public class Singleton {

    //声明Singleton类型的变量
    private static Singleton instance; //null

    //在静态代码块中进行赋值
    static {
        instance = new Singleton();
    }

    //私有构造方法
    private Singleton() {}

    //对外提供获取该类对象的方法
    public static Singleton getInstance() {
        return instance;
    }
}
