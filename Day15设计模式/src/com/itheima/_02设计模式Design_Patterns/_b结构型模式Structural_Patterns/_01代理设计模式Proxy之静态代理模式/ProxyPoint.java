package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._01代理设计模式Proxy之静态代理模式;

/**
 * @version v1.0
 * @ClassName: ProxyPoint
 * @Description: 代售点类
 * @Author: 黑马程序员
 */
public class ProxyPoint implements SellTickets {

    //声明卖火车票的接口
    private SellTickets sellTickets;

    //构造器
    public ProxyPoint(SellTickets sellTickets){
        this.sellTickets = sellTickets;
    }

    public void sell() {
        System.out.println("代售点收取一些服务费用");
        sellTickets.sell();
    }

}
