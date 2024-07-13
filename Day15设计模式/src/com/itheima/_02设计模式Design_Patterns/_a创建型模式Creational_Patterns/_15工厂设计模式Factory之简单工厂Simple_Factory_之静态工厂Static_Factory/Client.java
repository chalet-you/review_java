package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._15工厂设计模式Factory之简单工厂Simple_Factory_之静态工厂Static_Factory;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 简单工厂模式不属于GOF的23种经典设计模式
 *                     在开发中也有一部分人将工厂类中的创建对象的功能定义为静态的，
 *                     这个就是静态工厂模式，它也不是23种设计模式中的
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) {
        //创建咖啡店类对象
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("latte");

        System.out.println(coffee.getName());
    }
}
