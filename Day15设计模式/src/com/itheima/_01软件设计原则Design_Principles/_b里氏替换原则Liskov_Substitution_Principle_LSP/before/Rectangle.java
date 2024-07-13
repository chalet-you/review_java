package com.itheima._01软件设计原则Design_Principles._b里氏替换原则Liskov_Substitution_Principle_LSP.before;

/**
 * @version v1.0
 * @ClassName: Rectangle
 * @Description: 长方形类
 * @Author: 黑马程序员
 */
public class Rectangle {
    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
