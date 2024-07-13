package com.itheima._03线程池拓展1_线程池三种常用分类;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
     目标：线程池三种常用分类

     Java在Executors类下提供了一个静态方法得到一个线程池的对象：
          1.public static ExecutorService newFixedThreadPool(int nThreads)：一个1池N线程
               -- 创建一个1池N线程的线程池返回。
          2.public static ExecutorService newSingleThreadExecutor()： 1池1线程
               -- 创建一个1任务1线程的线程池返回。
          3.public static ExecutorService newCachedThreadPool(): 1池可扩容线程
               -- 创建一个1池可扩容的线程池返回。线程池根据需求创建线程，可扩容，遇强则强

 */

public class ThreadPoolsDemo01 {
    public static void main(String[] args) {
        // 一池五线程
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        // 一池一线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        // 一池可扩容线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool();


        // 10个客户请求
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool3.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool3.shutdown();
        }
    }
}
