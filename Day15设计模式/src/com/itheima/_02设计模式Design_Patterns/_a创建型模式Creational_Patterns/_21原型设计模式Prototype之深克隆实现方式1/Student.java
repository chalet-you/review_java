package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._21原型设计模式Prototype之深克隆实现方式1;

/**
 * @version v1.0
 * @ClassName: Student
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class Student implements Cloneable{

    //学生的姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    // 因为该类是基本数据类型和String类型，因此我们使用默认的clone完成即可
    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }
}
