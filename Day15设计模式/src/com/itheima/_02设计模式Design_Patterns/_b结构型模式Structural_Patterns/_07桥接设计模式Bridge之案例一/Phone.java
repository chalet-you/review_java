package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._07桥接设计模式Bridge之案例一;

public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }
    public void open(){
        brand.open();
    }
    public void close(){
        brand.close();
    }
    public void call(){
        brand.call();
    }
}
