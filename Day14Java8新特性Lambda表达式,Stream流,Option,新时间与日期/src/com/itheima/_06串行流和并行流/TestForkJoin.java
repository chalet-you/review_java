package com.itheima._06串行流和并行流;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

public class TestForkJoin {

    /**
     *   fork-join模型计算1 到 1000亿 之和
     */
    @Test
    public void test1(){
        long startTime = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinCalculate task = new ForkJoinCalculate(0, 100000000000L);
        Long sum = pool.invoke(task);  // 提交任务，并返回结果
        System.out.println(sum);

        long endTime = System.currentTimeMillis();
        System.out.println("总耗时："+(endTime-startTime)+"毫秒"); // 12.903s
    }

    /**
     *   普通for循环计算1 到 1000亿 之和
     */
    @Test
    public void test2(){
        long startTime = System.currentTimeMillis();

        long sum =0L;
        for (long i = 0; i <= 100000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时："+(endTime-startTime)+"毫秒"); // 32.492s
    }

    @Test
    public void test3(){
        long startTime = System.currentTimeMillis();
        // LongStream用rangeClosed方法创建 0 - 1000亿个数字
        // 此处是串行流，和我们之前普通for循环一样是单线程执行的
//        long sum = LongStream.rangeClosed(0,100000000000L)
//                .sequential()
//                .reduce(0, Long::sum);
        // 此处是并行流
        long sum = LongStream.rangeClosed(0, 100000000000L)
                .parallel()
                .reduce(0, Long::sum);

        System.out.println(sum);
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时："+(endTime-startTime)+"毫秒"); // 8.674s
    }

}
