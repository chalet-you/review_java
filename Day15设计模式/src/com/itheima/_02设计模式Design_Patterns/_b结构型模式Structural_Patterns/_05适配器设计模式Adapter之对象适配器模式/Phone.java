package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._05适配器设计模式Adapter之对象适配器模式;

// 定义一个手机类
public class Phone {
    // 有充电的功能，手机只能支持当前系统的5V业务接口
    public void charging(IVoltage5V iVoltage5V){
        if (iVoltage5V.output5V() == 5){
            System.out.println("电压为5V，可以充电~~~~");
        }else if (iVoltage5V.output5V() > 5){
            System.out.println("电压大于5V，不能充电");
        }
    }
}
