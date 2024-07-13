package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._22原型设计模式Prototype之深克隆实现方式2序列化反序列化推荐使用;

import java.io.Serializable;

/**
 * @version v1.0
 * @ClassName: Student
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class Student implements Serializable {

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
}
