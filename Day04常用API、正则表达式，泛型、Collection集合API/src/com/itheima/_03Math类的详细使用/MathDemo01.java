package com.itheima._03Math类的详细使用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
    目标：Math类的使用。
    Math用于做数学运算。
    Math类中的方法全部是静态方法，直接用类名调用即可。
    方法：
    方法名                                                说明
        -- public static int abs(int/long a)             获取参数a的绝对值：
        -- public static double ceil(double a)           向上取整
        -- public static double floor(double a)          向下取整
        -- public static double pow(double a, double b)  获取a的b次幂
        -- public static long round(double a)            四舍五入取整
        -- public static double random()                 返回一个 [0.0,1.0) 大于等于0.0 小于1.0的double的随机数。。。
                                                          返回一个double随机数， 0.0 <= double随机数 < 1.0

    小结：(int) (Math.random() * (max - min + 1) + min)    -- 随机生成一个[min ,max]的整数
    记住。
 */
public class MathDemo01 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int random33_77 = (int) (Math.random() * (77 - 33 + 1) + 33);
            System.out.println(random33_77);  // 生成 [33,77] 的 int 随机数
        }



    }
}
