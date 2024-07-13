package com.itheima._01软件设计原则Design_Principles._b里氏替换原则Liskov_Substitution_Principle_LSP.before;

/**
 * @version v1.0
 * @ClassName: Square
 * @Description: 正方形类
 * @Author: 黑马程序员
 */
public class Square extends Rectangle {

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setLength(width);
        super.setWidth(width);
    }
}
