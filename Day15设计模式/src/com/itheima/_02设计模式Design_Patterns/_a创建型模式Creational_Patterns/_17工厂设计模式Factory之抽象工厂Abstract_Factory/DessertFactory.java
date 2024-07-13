package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._17工厂设计模式Factory之抽象工厂Abstract_Factory;

/**
 * @version v1.0
 * @ClassName: DessertFactory
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public interface DessertFactory {

    //生产咖啡的功能
    Coffee createCoffee();

    //生产甜品的功能
    Dessert createDessert();
}
