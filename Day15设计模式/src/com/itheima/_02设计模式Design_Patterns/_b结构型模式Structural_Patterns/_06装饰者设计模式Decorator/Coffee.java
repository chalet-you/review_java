package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._06装饰者设计模式Decorator;

public class Coffee extends Drink {

    @Override
    public double cost() {
        return super.getPrice();
    }
}
