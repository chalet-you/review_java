package com.itheima._05Collections工具类;

import java.util.*;

/**
        目标：Collections工具类的使用。

        java.util.Collections:是集合工具类
        Collections并不属于集合，是用来操作集合的工具类。
        Collections有几个常用的API:
               - public static <T> boolean addAll(Collection<? super T> c, T... elements)
                    给集合对象批量添加元素！
               - public static void shuffle(List<?> list) :打乱集合顺序。
               - public static <T> void sort(List<T> list):将集合中元素按照默认规则排序。
               - public static <T> void sort(List<T> list，Comparator<? super T> ):将集合中元素按照指定规则排序。

 */
public class CollectionsDemo01 {
    public static void main(String[] args) {
        // 1.给集合批量添加元素
        Collection<String> names = new ArrayList<>();
        /**
         * 参数一：被添加元素的集合
         * 参数二：可变参数，一批元素
         */
        Collections.addAll(names, "曹操", "贾乃亮", "王宝强", "陈羽凡");
        System.out.println(names);

        // 2.打乱集合的顺序：public static void shuffle(List<?> list)
        // 注意：只能打乱有序的List集合。
        List<String> newnames = new ArrayList<>();
        Collections.addAll(newnames, "曹操", "贾乃亮", "王宝强", "陈羽凡");
        //Collections.shuffle(newnames); // 打乱顺序
        customerShuffle(newnames);
        System.out.println("自己实现打乱list集合顺序" + newnames);

        // 3.public static <T> void sort(List<T> list)：给List集合升序排序。
        List<Double> scores = new ArrayList<>();
        Collections.addAll(scores, 98.5, 66.5, 59.5, 66.5, 99.5);
        Collections.sort(scores); // 默认升序排序！
        System.out.println(scores);
    }


    // TODO：  方法一 : 自己实现打乱 List 集合顺序

    public static <T> void customerShuffle(List<T> list) {
        Random random = new Random();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(size);
            T temp = list.get(i);
            list.set(i, list.get(randomIndex));
            list.set(randomIndex, temp);
        }
    }

    // TODO：  方法二：自己实现打乱 List 集合顺序
    public static <T> void customerShuffle1(List<T> list) {
        Random random = new Random();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(size);
            Collections.swap(list, i, randomIndex);
        }
    }
}
