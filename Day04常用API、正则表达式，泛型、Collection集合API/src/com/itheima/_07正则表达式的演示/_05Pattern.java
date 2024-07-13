package com.itheima._07正则表达式的演示;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
    拓展：正则表达式爬取信息中的内容。(拓展)
    Pattern类：
              Pattern对象一个正则表达式对象，也称为匹配规则对象。Pattern类没有公共构造方法。要创建一个Pattern对象调用其静态方法
              compile(String regex)，它返回一个Pattern对象。该方法接受一个正则表达式作为它的第一个参数，
              如： Pattern pattern = Pattern.compile(regex)

        Pattern类的API
               --  public static Pattern compile(String regex){}
                      参数 regex 正则表达式
               --  public static Pattern compile(String regex, int flags){}
                      参数一： regex 正则表达式的字符串  参数二：flags  有Pattern.CASE_INSENSITIVE（忽略大小写值）等
               --  public Matcher matcher(CharSequence input){}
                      用于获得Matcher类的匹配器对象
               --  public static boolean matches(String regex, CharSequence input)
                      用于整体匹配 CharSequence input 是否满足正则表达式 String regex 并返回true或false


    Matcher类
               Matcher 对象是对输入字符串进行解释和匹配的引擎，成为：匹配器对象。与Pattern类一样，Matcher也没
               有公共构造方法。你需要调用Pattern 类的对象的matcher(CharSequence input)方法来获得一个Matcher类的对象

        Matcher类的API
                --  public int start()                 用于返回以前匹配的初始索引
                --  public int end()                   用于返回最后匹配字符之后的偏移量
                --  public boolean matches()           用于整体匹配方法，常用于，去校验某个字符串是否满足某个规则
                --  public boolean find(){}            用于匹配器是否匹配到了该匹配规则的
                --  public String group()              用于获取文本中的符合正则表达式的文本的子串
                --  public String group(int group){}   用于捕获分组的  从 group(1)开始 group(2)  ....

 */
public class _05Pattern {
    public static void main(String[] args) {
        String context1 = "来黑马程序学习Java,电话020-43422424，或者联系邮箱" +
                "itcast@itcast.cn,电话18762832633，0203232323" +
                "邮箱bozai@itcast.cn，400-100-3233 ，4001003232";
        // 需求：从上面的内容中爬取出 电话号码和邮箱。
        // 1.定义爬取规则：(邮箱的正则)|(手机号码的正则)|(电话的正则)
        String regex1 = "(\\w{1,}@\\w{2,10}(\\.\\w{2,10}){1,2})|(1[3-9]\\d{9})|(0\\d{2,5}-?\\d{5,15})|400-?\\d{3,8}-?\\d{3,8}";
        // 2.编译正则表达式成为一个匹配规则对象
        Pattern pattern1 = Pattern.compile(regex1);
        // 3.通过匹配规则对象得到一个匹配数据内容的匹配器对象
        Matcher matcher1 = pattern1.matcher(context1);
        // 4.通过匹配器去内容中爬取出信息
        while(matcher1.find()){
            System.out.println(matcher1.group());
        }

        System.out.println("------------验证某个字符串是否满足某个规则，而非要拿到文本中匹配规则的子串-----------------");
        // 验证文本context2是否满足 regex2的正则匹配规则

        String context2 = "hello youxuan521 hello world 6666";
        String regex2 = "hello.*";
        boolean result = Pattern.matches(regex2, context2);
        System.out.println("是否整体匹配成功：" +result);

        System.out.println("------------要拿到某个文本中匹配规则的子串-----------------");

        // 要拿到如下 context3中所有的数字
        String context3 = "hello youxuan521 hello world 6666";
        String regex3 = "\\d+";
        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(context3);
//        if (matcher3.find()){
//            System.out.println(matcher3.group());  // if 的话只能拿到 521
//        }

        while (matcher3.find()){
            System.out.println(matcher3.group());  // while 的话能拿到 521 和6666
        }


    }
}
