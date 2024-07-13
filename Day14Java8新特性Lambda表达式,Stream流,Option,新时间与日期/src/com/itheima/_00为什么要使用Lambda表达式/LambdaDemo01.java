package com.itheima._00为什么要使用Lambda表达式;
/**
      目标：为什么要使用Lambda表达式

      传统Java对于集合的操作，如果条件发生变化，需要重新定义一个方法，每个方法中代码过于冗余，而且也繁琐。
      那有没有优化代码的方式呢？
      解决方案：
                1、使用策略设设计模式优化代码
                2、使用匿名内部类优化代码
                3、使用Lambda表达式优化代码
 */

import java.util.*;

public class LambdaDemo01 {
    public static void main(String[] args) {

        // 原来匿名内部类的写法
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);


        // 现在Lambda的写法：
        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1, o2);
        TreeSet<Integer> ts1 = new TreeSet<>(com1);
        System.out.println("------------------------------------");


    }
}
