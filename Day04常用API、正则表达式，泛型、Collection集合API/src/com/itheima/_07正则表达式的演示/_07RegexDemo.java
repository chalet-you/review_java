package com.itheima._07正则表达式的演示;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
    目标：正则表达式的非捕获分组

    常用分组构造形式：
          1、(?:regex)
              表示：匹配 regex 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储
              以后使用的匹配。这对于用 "or" 字符 (|) 组合模式部件的情况很有用。
              例如，'industr(?:y|ies)'是比 'industry|industries'更经济的表达式。

          2、(?=regex)
              表示：它是一个非捕获匹配。例如，'Windows (?=95|98|NT|2000)'匹配的是
              "Windows 95" 或 "Windows 98" 或 "Windows NT" 或"Windows 2000"
              中的 "Windows"，但不匹配 "Windows 3.1" 中的 "Windows"

          3、(?!regex)
                表示：该表达式匹配不处于匹配 regex 的字符串的起始点的搜索字符串。它是
                一个非捕获匹配。例如，'Windows (?!95|98|NT|2000)' 匹配的是
                "Windows 3.1" 中的 "Windows"，但不匹配 "Windows 2000" 中的 "Windows"

    举例：
          以什么开头，不以什么开头，以什么结尾，不以什么结尾
          1、以 “你好”开头：
                            ^(?=你好)

          2、不以“你好”开头：
                            ^(?!你好)

          3、以“你好”结尾：
                            (?<=你好)$

          4、不以“你好”结尾：
                            (?<!你好)$

 */
public class _07RegexDemo {
    public static void main(String[] args) {
        String content = "hello 韩顺平教育 jack 韩顺平老师 韩顺平同学 hello 韩顺平";

        // 找到 韩顺平教育 、韩顺平老师、韩顺平同学 子字符串

        //String regex = "韩顺平教育|韩顺平老师|韩顺平同学";   等价于：String regex = "韩顺平(?:教育|老师|同学)";
        //上面的写法可以等价非捕获分组, 注意：不能 matcher.group(1)
        //String regex = "韩顺平(?:教育|老师|同学)";


        //找到 韩顺平 这个关键字,但是要求只是查找韩顺平教育和 韩顺平老师 中包含有的韩顺平
        //下面也是非捕获分组，不能使用 matcher.group(1)
        //String regex = "韩顺平(?=教育|老师)";
        //找到 韩顺平 这个关键字,但是要求只是查找 不是 (韩顺平教育 和 韩顺平老师) 中包含有的韩顺平
        //下面也是非捕获分组，不能使用 matcher.group(1)
        String regex = "韩顺平(?!教育|老师)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到---> " + matcher.group(0));
        }
    }
}

