package com.itheima._05成员变量和成员方法访问的拓展;

/**
    拓展：成员变量和成员方法访问的拓展。(面试常考)

    方法：实例方法，静态方法。
    成员变量：实例成员变量，静态成员变量。

    8种访问形式的问答：
         a.实例方法是否可以直接访问实例成员变量？可以的，因为它们都属于对象。
         b.实例方法是否可以直接访问静态成员变量？可以的，静态成员变量可以被共享访问。
         c.实例方法是否可以直接访问实例方法? 可以的，实例方法和实例方法都属于对象。
         d.实例方法是否可以直接访问静态方法？可以的，静态方法可以被共享访问！
         --------------------------------------------------------------------
         a.静态方法是否可以直接访问实例变量？ 不可以的，实例变量必须用对象访问！！
         b.静态方法是否可以直接访问静态变量？ 可以的，静态成员变量可以被共享访问。
         c.静态方法是否可以直接访问实例方法? 不可以的，实例方法必须用对象访问！！
         d.静态方法是否可以直接访问静态方法？可以的，静态方法可以被共享访问！！
 */
public class MethodFieldDemo {
    // 静态成员变量
    public static String schoolName = "黑马";
    // 实例成员变量
    private String name;

    // 静态方法
    public static void test(){
       // run(); // 报错了
       // System.out.println(name);// 报错了
        System.out.println(schoolName);
    }

    // 实例方法
    public void run(){
    }

    // 实例方法
    public void eat(){
        run();
        test();
        System.out.println(name);
        System.out.println(schoolName);
    }
}