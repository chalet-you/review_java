package com.itheima._06串行流和并行流;

import org.junit.Test;

import java.util.concurrent.RecursiveTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
    目标：使用Fork-Join模型计算 1 到 1000亿的累加操作

    模型：分而治之模型，把一个大任务拆分成很多个小任务来执行
    1到1000亿每次对半拆分计算累加值，直至达到临界值就不拆分
    1到1000亿 ---> 1到500亿 ---> 1到250亿 ---> 1到125亿 --->直至达到临界值不拆分
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = 532453952276485270L;
    // 定义一个计算的开始数字
    private long start;
    // 定义一个计算的结束数字
    private long end;
    // 定义一个临界值为1000万，直至计算的数字数目小于或等于临界值就不拆分任务
    private static final long THRESHOLD = 10000000L;

    public ForkJoinCalculate() {
    }

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    // 具体拆分任务计算的逻辑实现
    @Override
    protected Long compute() {
        long length = end - start;
        // 达到临界值THRESHOLD就不拆分任务，则计算该子任务
        if (length <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;

        } else {
            // 没达到临界值，则对半拆分任务
            long middle = (start + end) / 2;
            // 将任务拆分
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            left.fork();   // 拆分子任务，并压入线程队列中
            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();  // 拆分子任务，并压入线程队列中
            // 拆分后合并计算结果并返回
            return left.join() + right.join();
        }
    }

}
