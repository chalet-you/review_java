package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._06装饰者设计模式Decorator;

public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(2.0d);
    }
}
