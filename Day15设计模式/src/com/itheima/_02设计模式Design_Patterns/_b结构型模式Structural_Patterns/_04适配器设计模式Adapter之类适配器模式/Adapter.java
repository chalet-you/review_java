package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._04适配器设计模式Adapter之类适配器模式;

// 适配器类：既要实现当前系统的业务接口，又要继承现有组件库中已经存在的组件
public class Adapter extends Voltage220V implements IVoltage5V{
    @Override
    public int output5V() {
        // 获取到的220V电压
        int srcV = output220V();
        // 转成5V
        int destV = srcV / 44;
        return destV;
    }
}
