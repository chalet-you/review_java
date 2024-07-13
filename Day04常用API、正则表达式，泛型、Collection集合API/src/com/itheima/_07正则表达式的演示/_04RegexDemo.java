package com.itheima._07正则表达式的演示;
/**
    目标：String 类中使用正则表达式的应用。
        public String[] split(String regex)：
            -- 按照正则表达式匹配的内容进行分割字符串，反回一个字符串数组。
        public String replaceAll(String regex,String newStr)
            -- 按照正则表达式匹配的内容进行替换
        public String replace(CharSequence target, CharSequence replacement)
            -- 按照具体的字符串（没有正则效果）的内容进行替换
        public String replace(char oldChar, char newChar)
            -- 按照具体的字符（没有正则效果）的内容进行替换
        public boolean matches(String regex)
            -- 按照正则表达式去整体匹配字符串，常用于，去校验某个字符串是否满足某个规则


    注意：
         虽然以下案例中都是用了 . ，但是replace中.代表一个具体字符，
         在replaceAll中.代表匹配任意单个字符（除/r/n）。
         所以replaceAll将所有内容都替换为了/。


 */
public class _04RegexDemo {
    public static void main(String[] args) {
        // 1.split的基础用法
        String names = "贾乃亮,王宝强,陈羽凡";
        // 以“，”分割成字符串数组
        String[] nameArrs = names.split(",");
        for(int i = 0 ; i < nameArrs.length ; i++ ){
            String name = nameArrs[i];
            System.out.println(name);
        }

        System.out.println("----------------------");
        // 2.split集合正则表达式做分割
        String names1 = "贾乃亮lv434fda324王宝强87632fad2342423陈羽凡";
        // 以匹配正则表达式的内容为分割点分割成字符串数组
        String[] nameArrs1 = names1.split("\\w+");
        for(int i = 0 ; i < nameArrs1.length ; i++ ){
            String name = nameArrs1[i];
            System.out.println(name);
        }
        System.out.println("----------------------");
        // 3. public String replaceAll(String regex,String newStr)
        String names2 = "贾乃亮lv434fda324王宝强87632fad2342423陈羽凡";
        // 使用正则表达式定位出内容，替换成/
        System.out.println(names2.replaceAll("\\w+" , "/"));

        String names3 = "贾乃亮,王宝强,羽凡";
        System.out.println(names3.replaceAll(",","-"));

        String context = "hello world flink spark hive";
        boolean result = context.matches("hello.*");
        System.out.println("是否整体匹配成功："+result);

        System.out.println("----------------------");

        //创建一个字符串
        String str = "com.jd.test";

        //使用replace
        String replace = str.replace(".","/");       // 输出内容是：  com/jd/test
        String replace1 = str.replace('.', '/');      // 输出内容是：  com/jd/test

        //使用replaceAll
        String replaceAll = str.replaceAll(".","/");  // 输出内容是     ///////////

        //打印结果
        System.out.println("replace = " + replace);
        System.out.println("replace1 = " + replace1);
        System.out.println("replaceAll = " + replaceAll);
    }
}
