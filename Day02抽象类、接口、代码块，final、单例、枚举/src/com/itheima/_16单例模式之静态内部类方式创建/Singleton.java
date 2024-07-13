package com.itheima._16单例模式之静态内部类方式创建;

/**
      目标：静态内部类方式（单例模式）。

      单例模式的含义： 单例模式，是一种常用的软件设计模式。通过单例模式可以保证系统中，
          应用该模式的这个类永远只有一个实例。即一个类永远只有一个对象实例。
          单例是为了节约内存，单例在有些业务场景下还必须用到！！

      单例的应用场景：在实际开发中，有很多业务对象永远只需要一个，无论启动多少次
      我们只需要一个对象，例如任务管理对象，只需要一个对象。节约内存和性能。
      因为对象越多内存占用越大，极有可能出现内存溢出！

      实现单例模式目前提供两种方式：
          1.静态内部类方式的单例设计模式
              设计步骤：
              a.定义一个类Singleton，把构造器私有。
              b.定义一个静态内部类SingletonHolder，在静态内部类中定义一个常量Singleton INSTANCE并初始化它。
              c.在外部类中提供一个静态方法返回单例对象。

      小结：静态内部类单例模式中实例由内部类创建，由于 JVM 在加载外部类的过程中,
           是不会加载静态内部类的, 只有内部类的属性/方法被调用时才会被加载,
          并初始化其静态属性。静态属性由于被 static 修饰，保证只被实例化一次，并且严格保证实例化顺序。

      注意：静态内部类单例模式是一种优秀的单例模式，是开源项目中比较常用的一种单例模式。
           在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间的浪费。

 */
public class Singleton {

    //私有构造方法
    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}