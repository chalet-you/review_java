package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._23建造者设计模式Builder之案例实现;

/**
 * @version v1.0
 * @ClassName: OfoBuilder
 * @Description: ofo单车构建者，用来构建ofo单车
 * @Author: 黑马程序员
 */
public class OfoBuilder extends Builder {
    public void buildFrame() {
        bike.setFrame("铝合金车架");
    }

    public void buildSeat() {
        bike.setSeat("橡胶车座");
    }

    public Bike createBike() {
        return bike;
    }
}
