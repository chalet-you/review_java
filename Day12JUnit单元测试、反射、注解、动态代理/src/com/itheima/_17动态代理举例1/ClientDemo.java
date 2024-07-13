package com.itheima._17动态代理举例1;

/** 静态代理类是在编译周期生成
    动态代理类是在Java运行时动态生成
    目标：动态代理设计模式演示。

    开发步骤：
        1.代理对象，不需要实现接口，但是目标对象要实现接口，否则不能用动态代理。
        2.代理对象的生成，是利用JDK的API，动态的内存中构建代理对象。
        3.动态代理也叫做：JDK代理、接口代理
        4.代理类所在包：java.lang.reflect.proxy
        5.JDK实现代理只需要使用 newProxyInstance 方法，但是该方法需要接收三个参数，完整的写法是
              -- public static Object newProxyInstance(ClassLoader loader,
                                                       Class<?>[] interfaces,
                                                       InvocationHandler h)
                                                       throws IllegalArgumentException

 */
public class ClientDemo {
    public static void main(String[] args) {
        // 1.创建一个目标对象（被代理对象）
        ITeacherDao teacherDao = new TeacherDao();

        // 2.给目标对象，创建代理休想，可以转成ITeacherDao
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(teacherDao).getProxyInstance();

        // proxyInstance = class com.sun.proxy.$Proxy0 内存中动态生成了代理对象
        System.out.println("proxyInstance: " + proxyInstance.getClass());

        // 3.通过代理对象，调用目标对象的方法
        proxyInstance.teach();
        proxyInstance.sayHello(" 李雷");


    }
}












