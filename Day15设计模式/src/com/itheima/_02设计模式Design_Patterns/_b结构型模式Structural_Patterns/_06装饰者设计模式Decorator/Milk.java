package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._06装饰者设计模式Decorator;

public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(4.0d);
    }
}
