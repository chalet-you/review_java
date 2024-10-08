package com.itheima._05BigDecimal计算浮点型;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
    目标：BigDecimal大数据类。

    引入：
         浮点型运算的时候直接+  * / 可能会出现数据失真（精度问题）。
         BigDecimal可以解决浮点型运算数据失真的问题。

    BigDicimal类：
        包：java.math.
       创建对象的方式（最好的方式：）
           public static BigDecimal valueOf(double val) :包装浮点数成为大数据对象。
           public static BigDecimal valueOf(long val)  ：包装long型为大数据对象
       方法声明
           public BigDecimal add(BigDecimal value)       加法运算
           public BigDecimal subtract(BigDecimal value)  减法运算
           public BigDecimal multiply(BigDecimal value)  乘法运算
           public BigDecimal divide(BigDecimal value)    除法运算
           public double doubleValue():把BigDecimal转换成double类型。
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        // 浮点型运算的时候直接+  * / 可能会出现数据失真（精度问题）。
        System.out.println(0.1 + 0.2);
        System.out.println(0.09 + 0.01);
        System.out.println(1.0 - 0.32);
        System.out.println(1.015 * 100);
        System.out.println(1.301 / 100);

        System.out.println("-------------------------");
        double a = 0.1;
        double b = 0.2;
        double c = a + b;
        System.out.println(c);

        // 1.把浮点数转换成大数据对象运算
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        //BigDecimal c1 = a1.add(b1);  // 加法
        BigDecimal c1 = a1.divide(b1); // 除法   如果是 0.1/0.3本身就是非精确的运算，所以不能用大数据类型做精确的除法
        System.out.println(c1);

        // 结果可能需要继续使用!!!
        // BigDecimal只是解决精度问题的手段，double数据才是我们的目的！！
        double rs = c1.doubleValue();
        System.out.println(rs);
        System.out.println("=======================================");

        // TODO: double类型保留两位小数：并且四舍五入：
        Random random = new Random();
        double d = random.nextDouble() *100;
        // setScale(2, RoundingMode.HALF_UP) 2 表示保留 2 位小数，RoundingMode.HALF_UP表示四舍五入
        BigDecimal d1 = BigDecimal.valueOf(d).setScale(2, RoundingMode.HALF_UP);

        System.out.println("原始的double数：" +d+"--->保留2位小数并且四舍五入"+d1);


    }
}
