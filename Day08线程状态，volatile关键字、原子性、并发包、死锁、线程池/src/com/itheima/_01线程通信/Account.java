package com.itheima._01线程通信;
// 账户对象
public class Account {
    private String cardId ;
    private double money ; // 余额。

    public Account() {
    }

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }
    // 亲爸，干爹，岳父
    public synchronized void saveMoney(double money) {
        try{
            // 1.知道是谁来存钱
            String name = Thread.currentThread().getName();
            // 2.判断余额是否足够
            if(this.money > 0){
                // 5.等待自己，唤醒别人！
                this.notifyAll();
                this.wait();
            }else{
                // 3.钱没有，存钱
                this.money += money;
                System.out.println(name+"来存钱，存入了"+money+"剩余："+this.money);
                // 4.等待自己，唤醒别人！
                this.notifyAll();
                this.wait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // 小明 小红
    public synchronized void drawMoney(double money) {
        try{
            // 1.知道是谁来取钱
            String name = Thread.currentThread().getName();
            // 2.判断余额是否足够
            if(this.money > 0){
                // 3.账户有钱，有钱可以取
                this.money -= money;
                System.out.println(name+"来取钱"+money+"取钱后剩余："+this.money);
                // 4.没钱，一定要先唤醒别人，再等待自己，。否则 TODO：如果等待自己再唤醒别人，那么后面的代码就没法执行了
                // TODO：this.wait(); this.notifyAll(); 自己都等待了，后面唤醒别人的代码就没法执行了。。。
                this.notifyAll();
                this.wait();
            }else{
                // 5.余额不足，没钱，先唤醒别人，等待自己，。
                this.notifyAll();
                this.wait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }



}
