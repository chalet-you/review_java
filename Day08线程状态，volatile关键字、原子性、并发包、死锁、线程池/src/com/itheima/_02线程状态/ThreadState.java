package com.itheima._02线程状态;

import java.util.Arrays;

/**
     目标：线程状态（面试必考）

     Java中的Thread类中定义了一个枚举类State，里面有6个值
    public class Thread implements Runnable{
         ...
         public enum State {

            // 线程刚被创建，但是并未启动。还没调用start方法。MyThread t = new MyThread只有线程对象，没有线程特征。
            NEW,(新建状态)

            // 线程可以在java虚拟机中运行的状态，可能正在运行自己代码，也可能没有，这取决于操作系统处理器。调用了t.start()方法 ：就绪（经典叫法）
            RUNNABLE,(可运行)

            // 当一个线程试图获取一个对象锁，而该对象锁被其他的线程持有，则该线程进入Blocked状态；当该线程持有锁时，该线程将变成Runnable状态。
            BLOCKED,(锁阻塞)

            // 一个线程在等待另一个线程执行一个（唤醒）动作时，该线程进入Waiting状态。进入这个状态后是不能自动唤醒的，必须等待另一个线程调用notify或者notifyAll方法才能够唤醒。
            WAITING,(无限等待)

            // 同waiting状态，有几个方法有超时参数，调用他们将进入Timed Waiting状态。这一状态将一直保持到超时期满或者接收到唤醒通知。带有超时参数的常用方法有Thread.sleep 、Object.wait。
            TIMED_WAITING,(计时等待)

            // 因为run方法正常退出而死亡，或者因为没有捕获的异常终止了run方法而死亡。
            TERMINATED,(被终止)
         }
         ...
    }


 */
public class ThreadState {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Thread.State.values()));
        // [NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED]
    }
}
