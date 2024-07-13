package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._18工厂设计模式Factory之JDK源码解析_Collection_iterator方法;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
     Collection接口：抽象工厂
           -- Iterator<E> iterator();

     ArrayList类：具体工厂类
           -- public Iterator<E> iterator() {
                  return new Itr();
              }
           -- private class Itr implements Iterator<E> {...}

     Iterator接口：抽象商品类

     ArrayList$Itr：ArrayList类中的Iter内部类是具体的商品类

     小结：
           Collection接口是抽象工厂类，ArrayList是具体的工厂类；
           Iterator接口是抽象商品类，ArrayList类中的Iter内部类是具体的商品类。
           在具体的工厂类中iterator()方法创建具体的商品类的对象。
 */
public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("令狐冲");
        list.add("风清扬");
        list.add("任我行");

        //获取迭代器对象
        Iterator<String> it = list.iterator();
        //使用迭代器遍历
        while(it.hasNext()) {
            String ele = it.next();
            System.out.println(ele);
        }
    }
}