package com.itheima._16静态代理举例;

/** 静态代理类是在编译周期生成
    动态代理类是在Java运行时动态生成
    目标：静态代理设计模式演示。

    开发步骤：
        1.定义一个接口：ITeacherDao。
        2.目标对象 TeacherDao 实现ITeacherDao。
        3.使用静态代理方式，就需要在代理对象TeacherDaoProxy中也实现ITeacherDao
        4.调用的时候通过调用代理对象的方法来调用目标对象
        5.特别提醒：静态代理类与被代理类要实现相同的接口，然后通过调用相同的方法来调用目标对象的方法

 */
public class ClientDemo {
    public static void main(String[] args) {
        // 1.创建一个目标对象（被代理对象）
        TeacherDao teacherDao = new TeacherDao();

        // 2.创建一个代理对象，同时将被代理对象传递给代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        // 3.通过代理对象，调用到被代理对象的方法
        // 即：执行的是代理对象的方法，代理对象再去调用目标对象的方法
        teacherDaoProxy.teach();


    }
}












