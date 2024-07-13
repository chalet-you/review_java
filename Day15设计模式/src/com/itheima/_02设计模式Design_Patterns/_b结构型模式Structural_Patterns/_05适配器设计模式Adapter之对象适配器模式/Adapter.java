package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._05适配器设计模式Adapter之对象适配器模式;



/**
     对象适配器实现：
           釆用将现有组件库中已经实现的组件引入适配器类中，
           同时实现当前系统的业务接口。。尽量使用聚合、组合来替代继承
 */

public class Adapter implements IVoltage5V{
    // 关联关系--聚合
    private Voltage220V voltage220V;

    // 通过构造器，传入一个 Voltage220V 实例
    public Adapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        // 获取到的220V电压
        int srcV = voltage220V.output220V();
        System.out.println("使用对象适配器，进行适配~~~");
        // 转成5V
        int destV = srcV / 44;
        return destV;
    }
}
