package com.itheima._15收集Stream流;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
    目标：收集Stream流:把Stream流的数据转回成集合。

    引入：
         Stream的作用是：把集合转换成一根传送带，借用Stream流的强大功能进行的操作。
         但是实际开发中数据最终的形式还是应该是集合，最终Stream流操作完毕以后还是要转换成集合。
         这就是收集Stream流。

    收集Stream流的含义：就是把Stream流的数据转回到集合中去。

    Stream流：手段。
    集合：才是目的。

    Stream流提供 collect(Collector<? super T, A, R> collector) 方法，
    其参数需要一个 java.util.stream.Collector<T,A, R> 接口实例对象来指定收集到哪种集合中。

    幸运的是， java.util.stream.Collectors 类提供一些方法，可以作为 Collector 接口的实例
        -- public static <T> Collector<T, ?, List<T>> toList()：转换为 List 集合。
        -- public static <T> Collector<T, ?, Set<T>> toSet()：转换为 Set 集合。
    TODO:
          Collectors.toList();
          Collectors.toMap();
          Collectors.toSet();
          Collectors.toCollection();
          Collectors.toCollection(ArrayList::new);  // 将元素分别归纳进具体 ArrayList 集合中
          Collectors.toCollection(HashSet::new)     // 将元素分别归纳进具体 HashSet 集合中
          Collectors.toMap(Pair::getKey, Pair::getValue,String::concat,HashMap::new)
                -- 参数1：指定 key
                -- 参数2：指定 value
                -- 参数3：如果key重复的时候，怎么处理value
                -- 参数4：指定具体的集合类型
          Collectors.toConcurrentMap();

    小结：
    收集Stream流的含义：就是把Stream流的数据转回到集合中去。

    熟练函数式编程，如Lambda表达式简化函数式接口的匿名内部类形式，
    以及四种方法引用简化Lambda表达式，以及流式编程思想如Stream简化集合或者数组的操作。
    TODO 更多可以查看文档：https://blog.csdn.net/agonie201218/article/details/125563291
 */
public class StreamDemo {
    // List<String> lists = Arrays.asList("张无忌","周芷若","赵敏","张强","张三丰","张三丰");
    String[] arr = {"张无忌", "周芷若", "赵敏", "张强", "张三丰", "张三丰"};

    // TODO 0.把stream流转换成数组。
    @Test
    public void test0() {
        Stream<String> zhangLists2 = Arrays.stream(arr).filter(s -> s.startsWith("张"));
        //Object[] arrs = zhangLists2.toArray();
        // 可以借用构造器引用申明转换成的数组类型！！！
        String[] arrs1 = zhangLists2.toArray(String[]::new);
        System.out.println("arrs1 = " + Arrays.toString(arrs1));
    }

    // TODO 1.把stream流转换成 list 集合和具体的 ArrayList 集合
    @Test
    public void test1() {
        // 转 List 集合
        List<String> lists = Stream.of(arr).collect(Collectors.toList());
        System.out.println("lists = " + lists);
        // 转 ArrayList 集合
        ArrayList<String> arrayList = Stream.of(arr).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("arrayList = " + arrayList);
    }

    // TODO 2.把stream流转换成 set 集合和具体的 HashSet 集合
    @Test
    public void test2() {
        // 转 Set 集合
        Set<String> sets = Stream.of(arr).filter(s -> s.startsWith("张")).collect(Collectors.toSet());
        System.out.println("sets = " + sets);
        // 转 HashSet 集合
        HashSet<String> hashSet = Stream.of(arr).filter(s -> s.startsWith("张")).collect(Collectors.toCollection(HashSet::new));
        System.out.println("hashSet = " + hashSet);
    }

    // TODO 3.把stream流转换成 Map 集合和具体的 HashMap 集合
    @Test
    public void test3() {

        List<String> lists = Arrays.asList("张无忌，赵敏", "张三丰，郭襄", "郭靖，黄蓉", "段誉，王语嫣", "张无忌，周芷若");
        // 转 Map 集合，key 表示名字 ，value 表示名字长度
        // TODO：如果 key 出现重复的话，以下指定 两个参数的 程序就会报错，
/*        Map<String, String> maps1 = lists.stream()
                .map(s -> new Pair<String, String>(s.split("，")[0], s.split("，")[1]))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue));*/


        //TODO key存在重复处理时，这里用后者覆盖前者来解决 key 重复问题
        Map<String, String> maps2 = lists.stream()
                .map(s -> new Pair<String, String>(s.split("，")[0], s.split("，")[1]))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue, (key1, key2) -> key2));

        System.out.println("maps2 = " + maps2);

        //TODO 转换成具体的 HashMap 集合
        lists.stream()
                .map(s -> new Pair<String, String>(s.split("，")[0], s.split("，")[1]))
                .collect(Collectors.toMap
                        (
                        new Function<Pair<String, String>, String>() {
                            @Override
                            public String apply(Pair<String, String> pair) {
                                return pair.getKey();
                            }
                        },
                        new Function<Pair<String, String>, String>() {
                            @Override
                            public String apply(Pair<String, String> pair) {
                                return pair.getValue();
                            }
                        },
                        new BinaryOperator<String>() {
                            @Override
                            public String apply(String s1, String s2) {
                                return s1.concat(s2);
                            }
                        },
                        new Supplier<HashMap<String, String>>() {
                            @Override
                            public HashMap<String, String> get() {
                                return new HashMap<>();
                            }
                        }
                        )
                );

        // 以上的简写版
        HashMap<String, String> maps3 = lists.stream()
                .map(s -> new Pair<String, String>(s.split("，")[0], s.split("，")[1]))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue, String::concat, HashMap::new));

        System.out.println("maps3 = " + maps3);

    }


}






