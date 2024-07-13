package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._07单例设计模式Singleton之懒汉式_方式4_静态内部类;

/**
      目标：静态内部类方式（单例模式）。

      实现单例模式目前提供两种方式：
          1.静态内部类方式的单例设计模式
              设计步骤：
              a.定义一个类Singleton，把构造器私有。
              b.定义一个静态内部类SingletonHolder，在静态内部类中定义一个常量Singleton INSTANCE并初始化它。
              c.在外部类中提供一个静态方法返回单例对象。

      说明：第一次加载Singleton类时不会去初始化INSTANCE，只有第一次调用getInstance，
           虚拟机加载SingletonHolder 并初始化INSTANCE，这样不仅能确保线程安全，
           也能保证 Singleton 类的唯一性。

      小结：静态内部类单例模式中实例由内部类创建，由于 JVM 在加载外部类的过程中,
           是不会加载静态内部类的, 只有内部类的属性/方法被调用时才会被加载,
          并初始化其静态属性。静态属性由于被 static 修饰，保证只被实例化一次，并且严格保证实例化顺序。

      注意：静态内部类单例模式是一种优秀的单例模式，是开源项目中比较常用的一种单例模式。
           在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间的浪费。

 */
public class Singleton {

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
}