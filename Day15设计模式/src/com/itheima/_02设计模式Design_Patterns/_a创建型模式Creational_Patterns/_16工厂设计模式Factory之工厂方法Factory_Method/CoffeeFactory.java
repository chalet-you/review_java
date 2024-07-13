package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._16工厂设计模式Factory之工厂方法Factory_Method;

/**
 * @version v1.0
 * @ClassName: CoffeeFactory
 * @Description: CoffeeFactory ： 抽象工厂
 * @Author: 黑马程序员
 */
public interface CoffeeFactory {

    //创建咖啡对象的方法
    Coffee createCoffee();
}
