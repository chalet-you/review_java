package com.itheima._16静态代理举例;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师授课中 。。。。。。");
    }
}
