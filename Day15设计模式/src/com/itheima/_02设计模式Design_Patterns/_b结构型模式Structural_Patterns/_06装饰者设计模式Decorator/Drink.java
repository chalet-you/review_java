package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._06装饰者设计模式Decorator;

// 抽象类主体
public abstract class Drink {
    // 定义一个描述属性：用于备注事物的名称
    public String des;
    // 定义一个单价属性：用于备注事物的价格
    private double price;


    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    // 定义一个计算费用的抽象方法：具体子类实现
    public abstract double cost();
}
