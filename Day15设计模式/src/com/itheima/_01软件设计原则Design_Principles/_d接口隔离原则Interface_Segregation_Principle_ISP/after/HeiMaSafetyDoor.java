package com.itheima._01软件设计原则Design_Principles._d接口隔离原则Interface_Segregation_Principle_ISP.after;

/**
 * @version v1.0
 * @ClassName: HeiMaSafetyDoor
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class HeiMaSafetyDoor implements AntiTheft,Fireproof,Waterproof {
    public void antiTheft() {
        System.out.println("防盗");
    }

    public void fireproof() {
        System.out.println("防火");
    }

    public void waterproof() {
        System.out.println("防水");
    }
}
