package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._13工厂设计模式Factory之无工厂设计模式分析;

/**
 * @version v1.0
 * @ClassName: Coffee
 * @Description: 咖啡类
 * @Author: 黑马程序员
 */
public abstract class Coffee {

    //抽象具体什么咖啡的名称
    public abstract String getName();

    //加糖
    public void addsugar() {
        System.out.println("加糖");
    }

    //加奶
    public void addMilk() {
        System.out.println("加奶");
    }
}
