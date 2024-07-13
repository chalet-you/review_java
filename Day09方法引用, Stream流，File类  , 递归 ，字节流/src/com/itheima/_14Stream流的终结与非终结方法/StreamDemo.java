package com.itheima._14Stream流的终结与非终结方法;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
    目标：终结与非终结方法。

    终结方法：一旦Stream调用了终结方法，流的操作就全部终结了，不能继续使用，
        只能创建新的Stream操作。
        终结方法： forEach , count，collect
        TODO：方法的返回值不是Stream类型，或者无返回值

    非终结方法：每次调用完成以后返回一个新的流对象,
        可以继续使用，支持链式编程！
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

        // forEach终结方法
        list.stream().filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3).forEach(System.out::println);

        // count终结方法
        long count =  list.stream().filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3).count();
        System.out.println(count);

        // collect终结方法
        List<String> newList = list.stream().filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .collect(Collectors.toList());
        System.out.println(newList);


    }
}
