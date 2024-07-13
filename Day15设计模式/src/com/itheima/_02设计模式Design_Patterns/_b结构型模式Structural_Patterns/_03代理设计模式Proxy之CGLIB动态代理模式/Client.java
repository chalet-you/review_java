package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._03代理设计模式Proxy之CGLIB动态代理模式;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description:
 * @Author:
 */
public class Client {
    public static void main(String[] args) {
        //创建代理工厂对象
        ProxyFactory factory = new ProxyFactory();
        //获取代理对象
        TrainStation proxyObject = factory.getProxyObject();
        //调用代理对象中的sell方法卖票
        proxyObject.sell();

        System.out.println(proxyObject.getClass());

        //让程序一直执行
        while(true) {}

    }
}
