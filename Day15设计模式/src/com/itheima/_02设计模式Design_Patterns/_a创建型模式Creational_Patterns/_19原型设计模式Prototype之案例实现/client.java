package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._19原型设计模式Prototype之案例实现;

/**
 * @version v1.0
 * @ClassName: client
 * @Description: TODO(一句话描述该类的功能)
 * @Author:
 */
public class client {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建一个原型类对象
        Prototype prototype = new Prototype();
        prototype.setName("张三");
        prototype.setAge(18);

        //调用Prototype类中的clone方法进行对象的克隆
        Prototype clone = prototype.clone();
        System.out.println(prototype.hashCode());
        System.out.println(prototype);
        System.out.println(clone.hashCode());
        System.out.println(clone);

        System.out.println("原型对象和克隆出来的是否是同一个对象？" + (prototype == clone));
    }
}
