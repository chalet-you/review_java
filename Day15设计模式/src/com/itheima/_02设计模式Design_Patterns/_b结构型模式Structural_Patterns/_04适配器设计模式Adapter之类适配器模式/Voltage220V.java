package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._04适配器设计模式Adapter之类适配器模式;

/**
     目标：类适配器模式实现

     举例：以生活中手机充电器为例子，充电器本身相当于Adapter，220V交流电相当于被适配者，
           我们的目标是5V直流电，手机只能支持5V的直流电
           （即：当前系统手机的业务接口，现有的组件库中只有220V的交流电）
 */
// 被适配的类：即现有组件库中已存在的组件只有220V
public class Voltage220V {
    // 输出220V的电压
    public int output220V(){
        int src = 220;
        System.out.println("电压=" + src + "伏");
        return src;
    }
}
