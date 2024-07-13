package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._15工厂设计模式Factory之简单工厂Simple_Factory_之静态工厂Static_Factory_加配置文件解除耦合_拓展;

/**
 * @version v1.0
 * @ClassName: Coffee
 * @Description: 咖啡类
 * @Author: 黑马程序员
 */
public abstract class Coffee {

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
