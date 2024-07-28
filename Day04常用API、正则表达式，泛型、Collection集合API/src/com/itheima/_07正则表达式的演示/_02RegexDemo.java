package com.itheima._07正则表达式的演示;

/**
    目标：深入学习正则表达式的写法。


    转义号 \\
        \\ 符号  说明：在我们使用正则表达式去检索某些有特殊含义字符的时候，需要用到转义符号，否
                 则检索不到结果，甚至会报错。案例：用 $ 去匹配 "abc$(" 会怎么样？用 ( 去匹配 "abc$(" 会怎么样？
                 注意： 在Java中的正则表达式中，两个 \\ 代表其他语言中的一个 \


    字符匹配符
        [ ]  可接受的字符列表    比如： [abc]   匹配 a、b 或 c中任意一个字符
        [^]  不接受的字符列表    比如： [^abc]  匹配 除a、b或c之外的任意一个字符，包括数字和特殊字符
        -    连字符             比如： [a-z]  匹配 a至z中小写字母任意一个字符


    字符类
         [abc] a、b 或 c（简单类）
         [^abc] 任何字符，除了 a、b 或 c（否定）
         [a-zA-Z] a 到 z 或 A 到 Z，两头的字母包括在内（范围）
         [a-d[m-p]] a 到 d 或 m 到 p：[a-dm-p]（并集）
         [a-z&&[def23]] d、e 或 f（交集）
         [a-z&&[^bc]] a 到 z，除了 b 和 c：[ad-z]（减去）
         [a-z&&[^m-p]] a 到 z，而非 m 到 p：[a-lq-z]（减去）

    预定义字符类
         .  匹配非换行符（\n是换行符）的任何字符
         \\d 匹配一个数字字符：[0-9]                                  （digital 数字的）缩写
         \\D 匹配一个非数字字符： [^0-9]
         \\s 匹配空白字符：[ \t\n\x0B\f\r]  包含空格、制表符、换页符    （space 空白的）缩写
                -- \x20  ：只匹配一个空格
                -- \f    :只匹配一个换页符
                -- \n    :只匹配一个换行符
                -- \r    :只匹配一个回车符
         \\S 匹配任何非空白字符：[^\s]
         \\w 匹配字母、数字、下划线字符：[a-zA-Z_0-9]、但不匹配汉字      （word）单词字符缩写
         \\W 匹配非字母、数字、下划线字符：[^\w] 或者[^a-zA-Z_0-9]
         \\t  匹配一个制表符

    以上正则匹配只能校验单个字符。


    选择匹配符号
          |    匹配 "|" 之前或之后的表达式     比如：ab|cd     匹配 ab或者cd


    Greedy 数量词
         X?       X，一次或 0 次
         X*       X，零次或多次
         X+       X，一次或多次
         X{n}     X，恰好 n 次
         X{n,}    X，至少 n 次
         X{n,m}   X，至少 n 次，但是不超过 m 次

    定位符
         ^    指定起始字符    比如：^[0-9]+[a-z]*     匹配以至少1个数字开头，后接任意个小写的字符串   如：123、6aa、555edf
         $    指定结束字符    比如：^[0-9]\\-[a-z]+$  以1个数字开头后接连字符 “-”，并以至少1个小写字母结尾的字符串  如：1-a
         \\b  匹配目标字符串的边界   比如：you\\b      这里说的字符串的边界指的是子串间有空格，或者是目标字符串的结束位置
         \B   匹配目标字符串的非边界


    其他
         ^[\u0391-\uffe5]+$        匹配汉字     汉字的编码值范围是 [\u0391-\uffe5]
         [.] 和 \\.                都是匹配 点号 . 本身自己
         [?] 和 \\?                都是匹配 问号 ? 本生自己
         [*] 和 \\*                都是匹配 星号 * 本生自己

    正则不区分字母大小写
        (?!)abc                    表示abc都不区分大小写
        a(?!)bc                    表示bc不区分大小写
        a((?!)b)c                  表示只有b不区分大小写
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE)

    贪婪匹配和惰性匹配
        .*                         贪婪匹配
        .*?                        惰性匹配

        举例1：
               str：玩儿吃鸡游戏，晚上一起上游戏，干嘛呢？打游戏啊
               reg：玩儿.*?游戏
               此时匹配的是：共找打 1 处匹配
                            玩儿吃鸡游戏

        举例2：
               str：玩儿吃鸡游戏，晚上一起上游戏，干嘛呢？打游戏啊
               reg：玩儿.*游戏
               此时匹配的是：共找打 1 处匹配
                            玩儿吃鸡游戏，晚上一起上游戏，干嘛呢？打游戏
        举例3：
               str：abxmnpxhijkxcx
               reg：.*?x
               此时匹配的是：共找到 4 处匹配：
                            abx
                            mnpx
                            hijkx
                            cx
        举例4：
               str：<div>胡辣汤</div>
               reg：<.*>
               此时匹配的是：共找到 1 处匹配
                            <div>胡辣汤</div>
        举例5：
               str：<div>胡辣汤</div>
               reg：<.*?>
               此时匹配的是：共找到 2 处匹配
                            <div>
                            </div>
        举例6：
               str：<div>胡辣汤</div><span>饭团</span>
               reg：<div>.*?</div>
               此时匹配的是：共找到 1 处匹配
                            <div>胡辣汤</div>


 */
public class _02RegexDemo {
    public static void main(String[] args) {
        //public boolean matches(String regex):按照正则表达式去整体匹配字符串，常用于，去校验某个字符串是否满足某个规则，匹配返回true
        // 只能是 a  b  c
        System.out.println("a".matches("[abc]")); // true
        System.out.println("z".matches("[abc]")); // false

        // 不能出现a  b  c
        System.out.println("a".matches("[^abc]")); // false
        System.out.println("z".matches("[^abc]")); // true

        System.out.println("a".matches("\\d")); // false
        System.out.println("3".matches("\\d")); // true
        System.out.println("333".matches("\\d")); // false
        System.out.println("z".matches("\\w")); // true
        System.out.println("2".matches("\\w")); // true
        System.out.println("21".matches("\\w")); // false
        System.out.println("你".matches("\\w")); // false
        //  以上正则匹配只能校验单个字符。

        // 校验密码
        // 必须是数字 字母 下划线 至少 6位
        System.out.println("ssds3c".matches("\\w{6,}")); // true
        System.out.println("ssdsc".matches("\\w{6,}")); // false
        System.out.println("ssdsda232s你c".matches("\\w{6,}")); // false

        // 验证。必须是数字和字符  必须是4位
        System.out.println("dsd2".matches("[a-zA-Z0-9]{4}")); // true
        System.out.println("A3dy".matches("[a-zA-Z0-9]{4}")); // true
        System.out.println("A3dy2".matches("[a-zA-Z0-9]{4}")); // false


    }
}
