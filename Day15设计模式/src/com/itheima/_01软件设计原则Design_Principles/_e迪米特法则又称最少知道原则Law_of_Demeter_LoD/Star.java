package com.itheima._01软件设计原则Design_Principles._e迪米特法则又称最少知道原则Law_of_Demeter_LoD;

/**
 * @version v1.0
 * @ClassName: Star
 * @Description: 明星类
 * @Author: 黑马程序员
 */
public class Star {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
