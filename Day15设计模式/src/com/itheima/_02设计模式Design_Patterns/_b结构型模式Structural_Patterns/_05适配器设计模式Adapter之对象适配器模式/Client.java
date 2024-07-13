package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._05适配器设计模式Adapter之对象适配器模式;


/**
      目标：对象适配器模式实现

      举例：以生活中手机充电器为例子，充电器本身相当于Adapter，220V交流电相当于被适配者，
           我们的目标是5V直流电，手机只能支持5V的直流电
          （即：当前系统手机的业务接口，现有的组件库中只有220V的交流电）
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=========对象适配器模式=========");
        // 先买个手机
        Phone phone = new Phone();
        phone.charging(new Adapter(new Voltage220V()));

    }
}
