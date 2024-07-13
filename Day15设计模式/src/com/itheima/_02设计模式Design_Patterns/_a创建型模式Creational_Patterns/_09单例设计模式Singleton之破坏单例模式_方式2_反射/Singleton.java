package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._09单例设计模式Singleton之破坏单例模式_方式2_反射;


/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: 静态内部类方式
 * @Author: 黑马程序员
 */
public class Singleton {

    private static boolean flag = false;

    //私有构造方法
    private Singleton() {
    }

    //定义一个静态内部类
    private static class SingletonHolder {
        //在内部类中声明并初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton();
    }

    //提供公共的访问方式
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
