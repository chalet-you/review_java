package com.itheima._23递归的概述和应用理论;

/**
     目标：非规律化递归。
 ---------------------------------------------------------
     以上理论只能针对于规律化递归，如果是非规律化是不能套用以上公式的！
     非规律化递归的问题：文件搜索，啤酒问题。
     非规律化就看你的水平了！自己看着办！！

     非规律化递归：啤酒问题：（作业）
     啤酒2元1瓶，4个盖子可以换一瓶，2个空瓶可以换一瓶
         ，问10元可以喝多少瓶，剩余多少盖子和瓶子！！  15 3 1
 */
public class RecursionDemo07 {
    //定义一个静态的成员变量用于存储可以喝酒的数量
    public static int totalNum;     // 总的喝酒数量数量
    public static int lastPingZiNum;
    public static int lastGaiZiNum;

    public static void main(String[] args) {

        buyBeer(6);
        System.out.println("总数：" + totalNum);
        System.out.println("剩余盖子数：" + lastGaiZiNum);
        System.out.println("剩余瓶子数：" + lastPingZiNum);
    }

    // 定义一个方法帮助用户买酒
    private static void buyBeer(int money) {
        // a.拿钱买酒
        int number = money / 2 ;
        // 累加起来
        totalNum += number;

        // 算出当前剩余的全部盖子和瓶子数，换算成金额继续购买
        int currentPingZiNum = lastPingZiNum + number ;
        int currentGaiZiNum = lastGaiZiNum + number ;
        // 把他们换算成金额
        int totalMoney = 0;
        totalMoney +=(currentPingZiNum / 2) * 2 ;
        // 算出剩余的瓶子
        lastPingZiNum = currentPingZiNum % 2 ;

        // 换算盖子
        totalMoney +=(currentGaiZiNum / 4) * 2;
        lastGaiZiNum = currentGaiZiNum % 4;

        // 继续拿钱买酒
        if (totalMoney >=2){
            buyBeer(totalMoney);
        }
    }


}
