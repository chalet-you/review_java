package com.itheima._20线程同步_Lock锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 账户类
public class Account {
    private double money ; // 余额
    private String cardId ;
    // 创建一把锁对象:因为账户对象对于小明小红是唯一的，所以这里的锁对象对于小明小红也是唯一的
    // TODO：ReentrantLock 是一种悲观锁，性能较差
    private final Lock lock = new ReentrantLock();
    public Account(){

    }
    public Account(String cardId,double money) {
        this.cardId = cardId;
        this.money = money;
    }
    // 小明、小红执行到此
    public void drawMoney(double money) {
        // 1.先拿到是谁来取钱：取当前线程对象的名称
        String name = Thread.currentThread().getName();
        lock.lock(); // 上锁~!
        // TODO :以下取钱逻辑，可能会出现异常，如果小明线程来取钱，出现异常，那么后面就永远无法解锁，所以解锁代码一定要在finally中
        // TODO：导致取钱逻辑被永远锁死了。。。索引要  try{}catch(){}finally{}
        try{
            if(this.money >= money){
                // 3.余额足够
                System.out.println(name+"来取钱，吐出："+money);
                // 4.更新余额
                this.money -= money;
                // 5.输出结果
                System.out.println(name+"来取钱"+money+"成功，取钱后剩余："+this.money);
            }else{
                // 6.余额不足
                System.out.println(name+"来取钱，余额不足，剩余"+this.money);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock(); // 解锁~!
        }

    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
