package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._15工厂设计模式Factory之简单工厂Simple_Factory_之静态工厂Static_Factory_加配置文件解除耦合_拓展;


/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) {
        //创建咖啡店类对象
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("american");

        System.out.println(coffee.getName());
    }
}
