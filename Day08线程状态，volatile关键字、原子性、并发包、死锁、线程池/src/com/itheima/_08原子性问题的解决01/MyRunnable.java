package com.itheima._08原子性问题的解决01;

/**
    目标：保证原子性操作的方案一：加锁


    如何保证变量访问的原子性呢?
        1.加锁实现线程安全。
        2.基于CAS方式的原子类。CAS是（Compare And Swap 比较再交换）
 */
public class MyRunnable implements Runnable {
    private volatile int count ;
    // 一次任务是一个整体，加100.
    @Override
    public void run() {
        // 对该变量进行++操作，100次
        for(int x = 1 ; x <= 100 ; x++) {
           synchronized (this){
               count++ ;
               System.out.println("count =========>>>> " + count);
           }
        }
    }
}

class VolatileAtomicThreadDemo {
    public static void main(String[] args) {
        // 创建VolatileAtomicThread对象
        Runnable target = new MyRunnable() ;
        // 启动100个线程执行100次任务。
        for(int x = 1 ; x <= 100 ; x++) {
            new Thread(target).start();
        }
    }

}