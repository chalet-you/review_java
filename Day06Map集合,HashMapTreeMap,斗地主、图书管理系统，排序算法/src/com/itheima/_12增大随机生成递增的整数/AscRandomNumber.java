package com.itheima._12增大随机生成递增的整数;
/**
 * 需求：随机生成一个[1 ,100]的整数，但是要增大随机生成单调递增的整数的概率
 */

import java.util.Random;

public class AscRandomNumber {
    public static void main(String[] args) {
        Random random = new Random();
        //定义一个阈值，表示单调递增的概率
        int threshold = 30;//表示单调递增的概率为  (100-threshold)%
        // 定义一个变量用于存储上次生成的随机数字，初始值为1
        int lastNum = 1;
        // TODO：循环一千次，随机生成一千个数字 [1 ,100] 的整数
        for (int i = 0; i < 10000; i++) {
            int currentNum = 1;
            if (random.nextInt(100) >= threshold) {  // 走递增的分支，概率为（100-threshold）%
                currentNum = (int) (Math.random() * (100 - lastNum + 1) + lastNum);  // 生成 [lastNum,100]的随机值
            } else { // 走递减的分支，概率为（threshold）%
                currentNum = (int) (Math.random() * (lastNum - 1 + 1) + 1); // 生成 [1,lastNum]的随机值

            }
            lastNum = currentNum;
            System.out.println(currentNum);

        }


    }
}
