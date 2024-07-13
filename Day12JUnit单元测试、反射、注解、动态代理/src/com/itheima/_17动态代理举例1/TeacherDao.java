package com.itheima._17动态代理举例1;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师授课中 。。。。。。");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello" +name);
    }
}
