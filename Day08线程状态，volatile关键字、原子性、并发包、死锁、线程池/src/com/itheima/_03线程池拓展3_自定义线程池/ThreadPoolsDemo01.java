package com.itheima._03线程池拓展3_自定义线程池;

import java.util.concurrent.*;

/**
     目标：自定义线程池。
     在阿里巴巴 Java 开发手册规范中规定：
     线程池不允许使用Executors 工具类创建，而是通过ThreadPoolExecutor的方式创建

     Executors 工具类创建的线程池弊端：
          1.FixedThreadPool 和 SingleThreadPool
            允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM
          2.CacheThreadPool 和 ScheduledThreadPool
            允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM



 */
public class ThreadPoolsDemo01 {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );


        // 10个客户请求
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
