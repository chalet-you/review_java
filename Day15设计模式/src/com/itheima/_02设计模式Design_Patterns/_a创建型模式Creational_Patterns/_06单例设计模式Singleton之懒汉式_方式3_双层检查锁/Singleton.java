package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._06单例设计模式Singleton之懒汉式_方式3_双层检查锁;

/**
      添加 `volatile` 关键字之后的双重检查锁模式是一种比较好的单例实现模式，
      能够保证在多线程的情况下线程安全也不会有性能问题。
 */
public class Singleton {

    //私有构造方法
    private Singleton() {}

    //声明Singleton类型的变量
    private static volatile Singleton instance;

    //对外提供公共的访问方式
    public static Singleton getInstance() {
        //第一次判断，如果instance的值不为null，不需要抢占锁，直接返回对象
        if(instance == null) {
            synchronized (Singleton.class) {
                //第二次判断
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
