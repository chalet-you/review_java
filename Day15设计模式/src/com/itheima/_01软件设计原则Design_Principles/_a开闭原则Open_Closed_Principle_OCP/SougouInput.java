package com.itheima._01软件设计原则Design_Principles._a开闭原则Open_Closed_Principle_OCP;

/**
 * @version v1.0
 * @ClassName: SougouInput
 * @Description: 搜狗输入法
 * @Author: 黑马程序员
 */
public class SougouInput {

    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display() {
        skin.display();
    }
}
