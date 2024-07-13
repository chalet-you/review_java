package com.itheima._01软件设计原则Design_Principles._d接口隔离原则Interface_Segregation_Principle_ISP.before;

/**
 * @version v1.0
 * @ClassName: HeimaSafetyDoor
 * @Description: 黑马品牌的安全门
 * @Author: 黑马程序员
 */
public class HeimaSafetyDoor implements SafetyDoor {
    public void antiTheft() {
        System.out.println("防盗");
    }

    public void fireProof() {
        System.out.println("防火");
    }

    public void waterProof() {
        System.out.println("防水");
    }
}
