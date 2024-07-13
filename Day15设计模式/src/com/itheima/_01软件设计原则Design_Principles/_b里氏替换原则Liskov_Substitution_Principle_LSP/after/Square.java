package com.itheima._01软件设计原则Design_Principles._b里氏替换原则Liskov_Substitution_Principle_LSP.after;

/**
 * @version v1.0
 * @ClassName: Square
 * @Description: 正方形
 * @Author: 黑马程序员
 */
public class Square implements Quadrilateral {

    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getLength() {
        return side;
    }

    public double getWidth() {
        return side;
    }
}
