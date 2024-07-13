package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._15工厂设计模式Factory之简单工厂Simple_Factory_之静态工厂Static_Factory_加配置文件解除耦合_拓展;



/**
 * @version v1.0
 * @ClassName: CoffeeStore
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class CoffeeStore {

    public Coffee orderCoffee(String type) {

        // 静态工厂
        Coffee coffee = CoffeeFactory.createCoffee(type);

        //加配料
        coffee.addMilk();
        coffee.addsugar();

        return coffee;
    }
}
