package com.itheima._03design_pattern_other._1config_factory;


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
