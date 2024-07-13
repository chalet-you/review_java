package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._01代理设计模式Proxy之静态代理模式;

/**
     目标：静态代理
     静态代理代理类在编译期就生成
 */
public class Client {
    public static void main(String[] args) {
        //创建目标对象（被代理类对象）火车站类对象
        TrainStation trainStation = new TrainStation();
        //创建代售点类对象
        ProxyPoint proxyPoint = new ProxyPoint(trainStation);
        //调用方法进行买票
        proxyPoint.sell();
    }
}
