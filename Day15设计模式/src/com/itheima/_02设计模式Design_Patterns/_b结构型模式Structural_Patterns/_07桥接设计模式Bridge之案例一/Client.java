package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._07桥接设计模式Bridge之案例一;

/**
     需求：现在对不同手机类型的不同品牌实现操作编程(比如:开机、关机、上网，打电话等)，如图:

                        |--华为
            |---折叠式---|--小米
            |           |--Vivo
            |
            |           |--华为
     手机-------直立式---|--小米
            |           |--Vivo
            |
            |           |--华为
            |---旋转式---|--小米
                        |--Vivo

 */
public class Client {
    public static void main(String[] args) {
        // 买个折叠式的小米手机
        XiaoMi xiaoMi = new XiaoMi();
        Phone foldedPhone = new FoldedPhone(xiaoMi);
        foldedPhone.open();
        foldedPhone.close();
        foldedPhone.call();
    }
}
