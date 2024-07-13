package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._16工厂设计模式Factory之工厂方法Factory_Method;



/**
 * @version v1.0
 * @ClassName: CoffeeStore
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    //点咖啡功能
    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        //加配料
        coffee.addMilk();
        coffee.addsugar();
        return coffee;
    }
}
