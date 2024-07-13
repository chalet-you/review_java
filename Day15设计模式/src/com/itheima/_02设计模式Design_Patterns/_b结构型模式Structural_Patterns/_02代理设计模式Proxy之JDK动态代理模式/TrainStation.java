package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._02代理设计模式Proxy之JDK动态代理模式;

/**
 * @version v1.0
 * @ClassName: TrainStation
 * @Description: 火车站类
 * @Author: 黑马程序员
 */
public class TrainStation implements SellTickets {

    public void sell() {
        System.out.println("火车站卖票");
    }
}
