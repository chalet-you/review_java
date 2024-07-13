package com.itheima._01软件设计原则Design_Principles._c依赖倒置原则Dependence_Inversion_Principle_DIP.after;

/**
 * @version v1.0
 * @ClassName: IntelCpu
 * @Description: Intel cpu
 * @Author: 黑马程序员
 */
public class IntelCpu implements Cpu {

    public void run() {
        System.out.println("使用Intel处理器");
    }
}
