package com.itheima._01软件设计原则Design_Principles._a开闭原则Open_Closed_Principle_OCP;

/**
 * @version v1.0
 * @ClassName: DefaultSkin
 * @Description: 默认皮肤类
 * @Author: 黑马程序员
 */
public class DefaultSkin extends AbstractSkin {

    public void display() {
        System.out.println("默认皮肤");
    }
}
