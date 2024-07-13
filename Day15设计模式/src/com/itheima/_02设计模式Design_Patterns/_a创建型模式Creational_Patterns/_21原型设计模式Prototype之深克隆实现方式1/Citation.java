package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._21原型设计模式Prototype之深克隆实现方式1;

/**
 * @version v1.0
 * @ClassName: Citation奖状
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class Citation implements Cloneable {
    private int id;
    private Student stu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    // 深克隆实现方式一：使用clone方法
    @Override
    public Citation clone() throws CloneNotSupportedException {
        // TODO:先完成基本数据类型（属性）和（String）类型的克隆
        Citation citation = (Citation) super.clone();
        // TODO：再对引用数据类型的属性，单独单独克隆处理
        Student student = stu.clone(); // 克隆出引用数据类型的属性
        citation.stu = student;        // 在把引用数据类型的属性赋值给克隆对象的引用属性
        return citation;
    }

    public void show() {
        System.out.println(stu.getName() + "同学：在2020学年第一学期中表现优秀，被评为三好学生。特发此状！");
    }
}
