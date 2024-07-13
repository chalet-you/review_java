package com.itheima._01软件设计原则Design_Principles._e迪米特法则又称最少知道原则Law_of_Demeter_LoD;

/**
 * @version v1.0
 * @ClassName: Fans
 * @Description: 粉丝类
 * @Author: 黑马程序员
 */
public class Fans {

    private String name;

    public String getName() {
        return name;
    }

    public Fans(String name) {
        this.name = name;
    }
}
