package com.itheima._06变量不可见性解决;

/**
    目标：并发编程下变量不可见性解决方案。
    现象：并发编程下，多线程修改变量，会出现线程间变量的不可见性
    解决线程间变量的不可见性方案有两种常见方式：
        1.加锁
            -- 每次加锁会清空自己线程的工作内存，重新读取主内存最新值
        2.对共享的变量进行volatile关键字修饰。
            -- volatile修饰的变量可以在多线程并发修改下，实现线程间变量的可见性
            -- 一旦一个线程修改了volatile修饰的变量，另一个线程可以立即读取到最新值





    解决线程间变量的不可见性的方案：
        希望所有线程对于主内存的成员变量修改，其他线程是可见的。
        （1）加锁：可以实现其他线程对变量修改的可见性。
             某一个线程进入synchronized代码块前后，执行过程入如下：
             a.线程获得锁
             b.清空工作内存
             c.从主内存拷贝共享变量最新的值到工作内存成为副本

        （2）可以给成员变量加上一个volatile关键字，立即就实现了成员变量多线程修改的可见性。

    小结：
         可以给成员变量加上一个volatile关键字，当一个线程修改了这个成员变量的值，其他线程可以立即看到修改后的值并使用！
         volatile与synchronized的区别。
         - volatile只能修饰实例变量和静态变量，而synchronized可以修饰方法，以及代码块。
         - volatile保证数据的可见性，但是不保证原子性(多线程进行写操作，不保证线程安全);
          而synchronized是一种排他（互斥）的机制，
 */
public class VisiblityDemo {
    public  static void main(String[] args) {
        // 1.启动线程，把线程对象中的flag改为true。
        VolatileThread t = new VolatileThread();
        t.start();

          // 2.主线程
//        while(true){
//            // 加锁会清空工作内存，读取主内存中的最新值到工作内存中来！
//            synchronized (VisiblityDemo.class){
//                if(t.isFlag()){
//                    System.out.println("执行了循环一次~~~~~~~");
//                }
//            }
//        }

            while(true){
                if(t.isFlag()){
                    System.out.println("执行了循环一次~~~~~~~");
                }

        }

    }
}

// 线程类。
class VolatileThread extends Thread {
    // 定义成员变量
    // volatile可以实现变量一旦被子线程修改，其他线程可以马上看到它修改后的最新值！
    private volatile boolean flag = false ;
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
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