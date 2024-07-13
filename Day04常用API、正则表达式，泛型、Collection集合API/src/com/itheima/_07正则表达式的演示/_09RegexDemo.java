package com.itheima._07正则表达式的演示;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
    目标：正则的分组、捕获、反向引用。

    经典的结巴程序
          把 类似："我.....我要.....学学学学.....大数据.....和编程java！"
          通过正则表达式 修改成 "我要学大数据和编程java！"

*/
public class _09RegexDemo {
    public static void main(String[] args) {
        String context = "我.....我要.....学学学学.....大数据.....和编程java！";

        // 1.去掉所有的点 .
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(context);
        context = matcher.replaceAll("");

        System.out.println("context = " + context);

        // 2.去掉重复的字  我我要学学学学大数据和编程java！
        //  思路
        //  (1)使用  (.)\\1+
        // （2）使用 反向引用 $1 来替换匹配到的内容

        // 注意：因为正则表达式变化了需要重置以下matcher匹配器
        /*pattern = Pattern.compile("(.)\\1+");
        matcher = pattern.matcher(context);
        while (matcher.find()){
            System.out.println("找到了："+ matcher.group(0));
        }

        // 使用 反向引用 $1 来替换匹配到的内容
        context = matcher.replaceAll("$1");
        System.out.println("context = " + context);*/

        // 3.使用链式编程去掉重复的字  我我要学学学学大数据和编程java！
        context = Pattern.compile("(.)\\1+").matcher(context).replaceAll("$1");
        System.out.println("context = " + context);

    }

}
