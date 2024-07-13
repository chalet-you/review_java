package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._10享元设计模式Flyweight;

/**
 * @version v1.0
 * @ClassName: AbstractBox
 * @Description: 抽象享元角色
 * @Author: 黑马程序员
 */
public abstract class AbstractBox {

    //获取图形的方法
    public abstract String getShape();

    //显示图形及颜色
    public void display(String color) {
        System.out.println("方块形状：" + getShape() + ", 颜色：" + color);
    }
}
