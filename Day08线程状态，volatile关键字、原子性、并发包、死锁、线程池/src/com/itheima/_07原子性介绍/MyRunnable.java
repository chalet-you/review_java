package com.itheima._07原子性介绍;

/**
    目标：volatile修饰变量的原子性研究。

    什么是原子性？
         原子性，是指一批操作是一个整体，要么同时成功，要么同时失败，不能被干扰

    小结：在多线程环境下，volatile关键字可以保证共享数据的可见性，
         但是并不能保证对数据操作的原子性（在多线程环境下volatile修饰的变量也是线程不安全的）。
         volatile的使用场景
             - 开关控制
             利用可见性特点，控制某一段代码执行或者关闭(比如今天课程的第一个案例)。
             - 多个线程操作共享变量，但是是有一个线程对其进行写操作，其他的线程都是读。此时加上更好，其他线程可以立即读取到最新值。
         volatile不能保证变量操作的原子性（安全性）。
 */
public class MyRunnable implements Runnable {
    private volatile int count;
    // 一次任务是一个整体，加100.
    @Override
    public void run() {
        // 对该变量进行++操作，100次
        for(int x = 1 ; x <= 100 ; x++) {
            count++ ;					
            System.out.println("count =========>>>> " + count);
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

