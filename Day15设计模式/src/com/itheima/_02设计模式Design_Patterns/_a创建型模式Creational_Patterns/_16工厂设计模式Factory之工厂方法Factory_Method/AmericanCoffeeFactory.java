package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._16工厂设计模式Factory之工厂方法Factory_Method;

/**
 * @version v1.0
 * @ClassName: AmericanCoffeeFactory
 * @Description: 美式咖啡工厂对象，专门用来生产美式咖啡
 * @Author: 黑马程序员
 */
public class AmericanCoffeeFactory implements CoffeeFactory {

    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
