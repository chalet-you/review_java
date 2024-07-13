package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._07桥接设计模式Bridge之案例一;

public class FoldedPhone extends Phone {
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println(" 折叠式手机");
    }

    @Override
    public void close() {
        super.close();
        System.out.println(" 折叠式手机");
    }

    @Override
    public void call() {
        super.call();
        System.out.println(" 折叠式手机");
    }
}
