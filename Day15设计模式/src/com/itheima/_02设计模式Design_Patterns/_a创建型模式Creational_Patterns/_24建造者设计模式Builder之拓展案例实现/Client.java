package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._24建造者设计模式Builder之拓展案例实现;

/**
     在使用建造者设计模式，代码有点重复的
     在Builder类中需要重新再定义一遍外部类的成员属性
 */
public class Client {
    public static void main(String[] args) {
        //创建手机对象   通过构建者对象获取手机对象
        Phone phone1 = Phone.builder()   // new Phone.Builder()获取内部类对象
                .setCpu("intel")
                .setScreen("三星屏幕")
                .setMemory("金士顿内存条")
                .setMainboard("华硕主板")
                .build();

        System.out.println(phone1);
        Phone phone2 = new Phone.Builder()
                .setCpu("intel")
                .setScreen("三星屏幕")
                .setMemory("金士顿内存条")
                .setMainboard("华硕主板")
                .build();

    }
}
