package com.itheima._10Stream流概述;

import java.util.ArrayList;
import java.util.List;

public class NotUseStream {
    public static void main(String[] args) {
        // 需求：从集合中筛选出所有姓张的人出来。然后再找出姓名长度是3的人。
        List<String> lists = new ArrayList<>();
        lists.add("张无忌");
        lists.add("周芷若");
        lists.add("赵敏");
        lists.add("张强");
        lists.add("张三丰");



        // a.先定义一个新的集合
        List<String> zhangAndThreeLists = new ArrayList<>();
        // b.然后遍历原集合每个元素，找到以姓张的并且姓名长度是3的元素，然后再把元素添加到新的集合中
        for (String s : lists) {
            if(s.startsWith("张") && s.length()==3){
                zhangAndThreeLists.add(s);
            }
        }
        System.out.println(zhangAndThreeLists);

    }
}
