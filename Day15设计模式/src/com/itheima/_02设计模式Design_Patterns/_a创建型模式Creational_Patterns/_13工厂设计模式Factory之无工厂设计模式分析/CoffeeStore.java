package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._13工厂设计模式Factory之无工厂设计模式分析;

/**
     缺点：把对象的创建和业务逻辑层没有分开，
     如果增加新咖啡时还是需要修业务逻辑的代码，违背了“开闭原则”。
 */
public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        //声明Coffee类型的变量，根据不同类型创建不同的coffee子类对象
        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您所点的咖啡没有");
        }
        //加配料
        coffee.addMilk();
        coffee.addsugar();

        return coffee;
    }
}
