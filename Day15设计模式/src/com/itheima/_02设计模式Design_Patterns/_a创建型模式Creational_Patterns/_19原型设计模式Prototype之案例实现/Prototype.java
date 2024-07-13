package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._19原型设计模式Prototype之案例实现;

import java.util.Objects;

/**
 * @version v1.0
 * @ClassName: Prototype
 * @Description: TODO(一句话描述该类的功能)
 * @Author:
 */
public class Prototype implements Cloneable {
    private String name;
    private Integer age;

    public Prototype() {
        System.out.println("具体的原型对象创建完成！无参");
    }

    public Prototype(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("具体的原型对象创建完成！有参");
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");

        return (Prototype) super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
