package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._10单例设计模式Singleton之解决破坏单例模式_方式1_序列化反序列化;

import java.io.Serializable;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: 静态内部类方式
 * @Author: 黑马程序员
 */
public class Singleton implements Serializable {

    //私有构造方法
    private Singleton() {}

    //定义一个静态内部类
    private static class SingletonHolder {
        //在内部类中声明并初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton();
    }

    //提供公共的访问方式
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //当进行反序列化时，会自动调用该方法，将该方法的返回值直接返回
    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }

}
