package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._23建造者设计模式Builder之案例实现;

/**
 * @version v1.0
 * @ClassName: Bike
 * @Description: 产品对象
 * @Author: 黑马程序员
 */
public class Bike {

    private String frame;//车架

    private String seat;//车座

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
