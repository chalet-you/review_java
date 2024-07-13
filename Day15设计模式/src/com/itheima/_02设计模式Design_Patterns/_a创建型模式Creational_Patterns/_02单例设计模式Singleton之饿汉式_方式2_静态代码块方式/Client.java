package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._02单例设计模式Singleton之饿汉式_方式2_静态代码块方式;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

        Singleton instance1 = Singleton.getInstance();

        //判断两次获取到的Singleton对象是否是同一个对象
        System.out.println(instance == instance1);
    }
}
