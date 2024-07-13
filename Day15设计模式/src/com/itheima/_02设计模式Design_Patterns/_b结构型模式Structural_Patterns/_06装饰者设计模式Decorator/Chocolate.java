package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._06装饰者设计模式Decorator;

// 具体的Decorator， 这里就是调味品
public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(3.0d); // 调味品 的价格
    }
}
