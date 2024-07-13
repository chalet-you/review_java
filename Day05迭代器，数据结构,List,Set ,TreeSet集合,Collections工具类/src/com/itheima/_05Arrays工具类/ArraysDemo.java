package com.itheima._05Arrays工具类;

import java.util.*;


/**
        目标：Arrays工具类的使用。

        java.util.Arrays:是数组工具类
        Arrays并不属于数组，是用来操作数组的工具类。
        Arrays有几个常用的API:
               - public static String toString(Xxx[] a) 把数组打成字符串输出！
               - public static void sort(Xxx[] a):将数组中有值特性元素按照默认升序规则排序。
               - public static <T> void sort(T[] a, Comparator<? super T> c):将数组中元素按照自定义指定规则排序。
               - public static <T> Stream<T> stream(T[] array):将给定的数组打成对应类型的流。
               - public static <T> List<T> asList(T... a):将给定的可变参数的数据打成List集合。
                    注意：Arrays.asList(...) 返回的这个集合的长度不能再次改变，当增加 or 删除元素会报不支持操作异常（UnsupportedOperationException）


 */
public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{33,2,11,5,22,10};

        // 1.toString 将数组打成字符串
        System.out.println(Arrays.toString(arr));
        System.out.println("-------------------------------------");

        // 2.sort(Xxx[] a) 将具有值特性类型的数组按照默认升序排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("-------------------------------------");

        // 3.sort(T[] a, Comparator<? super T> c) 将数组中元素按照指定规则排序
        // 需求：按照元素的首字符(忽略大小写)升序排序！！！
        String[] strs = new String[]{"James", "AA", "John",
                "Patricia","Dlei" , "Robert","Boom", "Cao" ,"black" ,
                "Michael", "Linda","cao","after","sBBB"};

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);// 按照元素的首字符(忽略大小写)比较。
            }
        });

        // 方法引用简化  Arrays.sort(strs, String::compareToIgnoreCase);


        System.out.println(Arrays.toString(strs));
        System.out.println("-------------------------------------");


        // 4.stream(Xxx[] array) 将数组打成流，然后可以使用链式编程
        // 需求：从数组中筛选出所有姓张的人出来。然后再找出姓名长度是3的人。
        String[] names = {"张无忌","周芷若","赵敏","张强","张三丰"};

        String[] zhangAndThreeArrays = Arrays
                // a.打成对应类型(String)的流
                .stream(names)
                // b.然后再作用Stream流中每个元素，过滤出姓张的并且姓名长度是3的元素
                .filter(element -> element.startsWith("张") && element.length() == 3)
                // c.最后再把Stream流变回数组
                .toArray(String[]::new);


        System.out.println(Arrays.toString(zhangAndThreeArrays));
        System.out.println("-------------------------------------");


        // 5.asList(T... a) 将给定的可变参数的数据打成List集合
        List<String> lists = Arrays.asList("我", "是", "谁");

        // lists.add("播妞");  // 会报不支持操作异常UnsupportedOperationException
        System.out.println(lists);

    }
}
