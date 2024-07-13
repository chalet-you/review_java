package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._13工厂设计模式Factory之无工厂设计模式分析;

/**
    缺点：把对象的创建和业务逻辑层没有分开，
         如果增加新咖啡时还是需要修业务逻辑的代码，违背了“开闭原则”。
 */
public class Client {
    public static void main(String[] args) {
        //1,创建咖啡店类
        CoffeeStore store = new CoffeeStore();
        //2,点咖啡
        Coffee coffee = store.orderCoffee("american");

        System.out.println(coffee.getName());
    }
}
