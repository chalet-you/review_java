package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._06装饰者设计模式Decorator;

public class Decorator extends Drink {
    // 被装饰者对象
    private Drink obj;


    // 组合
    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public double cost() {
        // getPrice() 自己价格(三种调味品的价格) + 三种单品咖啡的费用
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        // obj.getDes() 输出被装饰者的信息
        return des + super.getPrice() +" && " +obj.getDes();
    }
}
