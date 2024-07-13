package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._17工厂设计模式Factory之抽象工厂Abstract_Factory;

/**
 * @version v1.0
 * @ClassName: AmericanDessertFactory
 * @Description:
 *         没事风味的甜品工厂
 *             生产美式咖啡和抹茶慕斯
 * @Author: 黑马程序员
 */
public class AmericanDessertFactory implements DessertFactory {

    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
