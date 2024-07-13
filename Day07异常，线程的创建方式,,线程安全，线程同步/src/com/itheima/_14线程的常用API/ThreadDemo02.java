package com.itheima._14线程的常用API;

/**
    目标：线程休眠API.

    public static void sleep(long time): 让当前线程休眠多少毫秒再继续执行。

    上面方式缺点：
         如下：
         Thread.sleep(87000000);  你知道休眠多久吗？可读性比较差，需要自己改造一下
         Thread.sleep(24 * 60 * 60 * 1000 + 10 * 60 * 1000);
         现在你估计大概能知道休眠多久了，但还是很茫然，
         很无助，不写注释，谁知道休眠多久？单位还是毫秒。。

    优雅简单的方式如下：
                     TimeUnit.DAYS.sleep(1);
                     TimeUnit.MINUTES.sleep(10);
               或
                     TimeUnit.HOURS.sleep(24);
                     TimeUnit.MINUTES.sleep(10);
    使用 java.util.concurrent.TimeUnit 类就可以优雅的搞定，不需要过多的单位运算及修饰，很优雅，很简单


 */
public class ThreadDemo02 {
    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ; i++ ) {
            System.out.println(i);
            try {
                // 项目经理让我加上这行代码
                // 如果用户交钱了，我就去掉。
                Thread.sleep(1000); // 让当前线程休眠1s.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
