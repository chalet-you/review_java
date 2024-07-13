package com.itheima._03线程池拓展2_线程池7个参数介绍;
/**
       目标：线程池7个参数介绍。

       查看线程池三种常用分类的创建，底层都是 new 了一个ThreadPoolExecutor
       public ThreadPoolExecutor(int corePoolSize,
                                int maximumPoolSize,
                                long keepAliveTime,
                                TimeUnit unit,
                                BlockingQueue<Runnable> workQueue,
                                ThreadFactory threadFactory,
                                RejectedExecutionHandler handler)

       1.int corePoolSize
            -- 常驻线程数量
            线程池中的常驻核心线程数 创建线程池后，当有请求任务进来，就安排池中的线程去执行请求任务
            当线程池中的线程数目达到 corePoolSize 后，就会把到达的任务放到缓存队列中
       2.int maximumPoolSize
            -- 最大线程数量
            线程池能够容纳同时执行的最大线程数，此值必须大于等于1
       3.long keepAliveTime
            -- 线程存活时间
            多余的空闲线程的存活时间 当前线程池数量超过 corePoolSize 时，
            当空闲时间达到 keepAliveTime 值时， 多余空闲线程会被销毁直到只剩下 corePoolSize 个线程为止
       4.TimeUnit unit
            -- 时间的单位
       5.BlockingQueue<Runnable> workQueue
            -- 阻塞队列 。被提交但尚未被执行的任务
       6.ThreadFactory threadFactory
            -- 线程工厂
            表示生成线程池中工作线程的线程工厂<线程名字、线程序数...>，用于创建线程一般用默认的即可
       7.RejectedExecutionHandler handler
            -- 拒绝策略
            表示当队列满了并且工作线程大于等于线程池的最大线程数(maximumPoolSize)时，如何拒绝新的任务
            拒绝策略有4种
            AbortPolicy(默认)：直接抛出 RejectedExecutionException 异常阻止系统正常运行
            CallerRunsPolicy：将某些任务回退到调用者，从而降低新任务的流量
            DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务中加入队列中尝试再次提交当前任务
            DiscardPolicy：直接丢弃任务，不予任何处理也不抛出异常

 */
public class ThreadPoolsDemo01 {

}
