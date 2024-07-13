package com.itheima._07正则表达式的演示;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
    目标：正则表达式的分组

    常用分组构造形式：
          1、(regex)
              表示：非命名捕获，捕获匹配的子字符串。编号为 0 的第一个捕获是整个正则式匹配的文本
              其他捕获结果则根据左边括号的顺序从 1 开始自动编号。

          2、(?<name>regex)
              表示：命名捕获，将匹配的子字符串捕获到一个组名称或者编号中。用于name的字
              符串不能包含任何标点符号，并且不能以数字开头。可以使用单引号替代尖括号
              例如：(?'name')

 */
public class _06Pattern {
    public static void main(String[] args) {
        String content = "youxuanxuan s7789 nn1125han";
        //下面就是非命名分组
        //说明
        // 1. matcher.group(0) 得到匹配到的字符串
        // 2. matcher.group(1) 得到匹配到的字符串的第 1 个分组内容
        // 3. matcher.group(2) 得到匹配到的字符串的第 2 个分组内容
        //String regex = "(\\d\\d)(\\d\\d)";//匹配 4 个数字的字符串
        //命名分组： 即可以给分组取名
        String regex = "(?<g1>\\d\\d)(?<g2>\\d\\d)";//匹配 4 个数字的字符串
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到整个正则式 (\\d\\d)(\\d\\d) 匹配的文本--->" + matcher.group(0));
            System.out.println("第 1 个分组内容--->" + matcher.group(1));
            System.out.println("第 1 个分组内容[通过组名]--->" + matcher.group("g1"));
            System.out.println("第 2 个分组内容--->" + matcher.group(2));
            System.out.println("第 2 个分组内容[通过组名]--->" + matcher.group("g2"));
        }
    }
}

