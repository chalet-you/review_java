package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._09外观设计模式Facade;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO(一句话描述该类的功能)
 * @Author:
 */
public class Client {
    public static void main(String[] args) {
        //创建智能音箱对象
        SmartAppliancesFacade facade = new SmartAppliancesFacade();
        //控制家电
        facade.say("打开家电");

        System.out.println("==================");

        facade.say("关闭家电");
    }
}
