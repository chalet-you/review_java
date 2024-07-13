package com.itheima._03design_pattern_other._1config_factory;


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

        System.out.println("====================");

        Coffee latte = store.orderCoffee("latte");
        System.out.println(latte.getName());
    }
}
