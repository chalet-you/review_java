package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._05单例设计模式Singleton之懒汉式_方式2_线程安全;

/**
      该方式也实现了懒加载效果，同时又解决了线程安全问题。
      但是在getInstance()方法上添加了synchronized关键字，
      导致该方法的执行效果特别低。从上面代码我们可以看出，
      其实就是在初始化instance的时候才会出现线程安全问题，
      一旦初始化完成就不存在了。
 */
public class Singleton {

    //私有构造方法
    private Singleton() {}

    //声明Singleton类型的变量instance
    private static Singleton instance; //只是声明一个该类型的变量，并没有进行赋值

    //对外提供访问方式
    public static synchronized Singleton getInstance() {
        //判断instance是否为null，如果为null，说明还没有创建Singleton类的对象
        //如果没有，创建一个并返回，如果有，直接返回
        if(instance == null) {
            //线程1等待，线程2获取到cpu的执行权，也会进入到该判断里面
            instance = new Singleton();
        }
        return instance;
    }
}
