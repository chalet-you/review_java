package com.itheima._10Stream流概述;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
    目标： 演示Stream流的强大。

    什么是Stream流？
        在Java 8中，得益于Lambda所带来的函数式编程，
        引入了一个全新的Stream流概念 ，用于解决已有集合/数组类库有的弊端。

    Stream流能解决什么问题?
        可以解决已有集合类库或者数组API的弊端。
        Stream认为集合和数组操作的API很不好用，所以采用了Stream流简化集合和数组的操作！！

    小结：
        Stream流是用来简化集合类库或者数组API的弊端。
        Stream流其实就一根传送带，元素在上面可以被Stream流操作。
 */
public class UseStream {
    public static void main(String[] args) {
        // 需求：从集合中筛选出所有姓张的人出来。然后再找出姓名长度是3的人。
        List<String> lists = new ArrayList<>();
        lists.add("张无忌");
        lists.add("周芷若");
        lists.add("赵敏");
        lists.add("张强");
        lists.add("张三丰");

        List<String> zhangAndThreeLists = lists
                // step1：先把List集合转换成Stream流
                .stream()
                // step2：然后再作用Stream流中每个元素，过滤出姓张的并且姓名长度是3的元素
                .filter(s -> s.startsWith("张") && s.length() == 3)
                // step3：最后再把Stream流收集变回List集合
                .collect(Collectors.toList());

        System.out.println(zhangAndThreeLists);


    }
}
