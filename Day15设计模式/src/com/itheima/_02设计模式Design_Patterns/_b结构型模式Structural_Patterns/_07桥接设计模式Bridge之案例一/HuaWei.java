package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._07桥接设计模式Bridge之案例一;

public class HuaWei implements Brand {
    @Override
    public void open() {
        System.out.println("华为手机开机");
    }

    @Override
    public void close() {
        System.out.println("华为手机关机");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }
}
