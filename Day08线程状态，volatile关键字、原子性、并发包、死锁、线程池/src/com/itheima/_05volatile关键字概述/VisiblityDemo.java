package com.itheima._05volatile关键字概述;

/**
    目标：并发编程下，多线程访问变量的不可见性问题。


    引入:
         多个线程访问共享变量，会出现一个线程修改变量的值后，其他线程看不到变量最新值的情况。
    结论：
         并发编程下，多线程修改变量，会出现线程间变量的不可见性。
    不可见性的原因：
        每个线程都有自己的工作内存，线程都是从主内存拷贝共享变量的副本值。
        每个线程是在自己的工作内存中操作共享变量的
 */
public class VisiblityDemo {
    public  static void main(String[] args) {
        // 1.启动线程，把线程对象中的flag改为true。
        VolatileThread t = new VolatileThread();
        t.start();

        // 2.主线程
        while(true){
            // 这里读取到了flag值一直是false,虽然线程已经把它的值改成了true。
            if(t.isFlag()){
                System.out.println("执行了循环一次~~~~~~~");
            }
        }

    }
}
// 线程类。
class VolatileThread extends Thread {
    // 定义成员变量
    private boolean flag = false ;
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        // 模拟修改flag变量之前有很多代码，用sleep
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 将flag的值更改为true
        this.flag = true ;
        System.out.println("线程修改了flag=" + flag);
    }
}