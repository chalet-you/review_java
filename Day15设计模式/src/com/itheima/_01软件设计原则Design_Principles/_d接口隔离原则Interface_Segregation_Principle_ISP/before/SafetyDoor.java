package com.itheima._01软件设计原则Design_Principles._d接口隔离原则Interface_Segregation_Principle_ISP.before;

/**
 * @version v1.0
 * @ClassName: SafetyDoor
 * @Description: 安全门接口
 * @Author: 黑马程序员
 */
public interface SafetyDoor {

    //防盗
    void antiTheft();

    //防火
    void fireProof();

    //防水
    void waterProof();
}
