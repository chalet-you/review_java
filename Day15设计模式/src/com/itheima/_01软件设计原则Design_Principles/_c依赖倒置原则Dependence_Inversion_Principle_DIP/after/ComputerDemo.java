package com.itheima._01软件设计原则Design_Principles._c依赖倒置原则Dependence_Inversion_Principle_DIP.after;

/**
 * @version v1.0
 * @ClassName: ComputerDemo
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class ComputerDemo {
    public static void main(String[] args) {

        //创建计算机的组件对象
        HardDisk hardDisk = new XiJieHardDisk();
        Cpu cpu = new IntelCpu();
        Memory memory = new KingstonMemory();

        //创建计算机对象
        Computer c = new Computer();
        //组装计算机
        c.setCpu(cpu);
        c.setHardDisk(hardDisk);
        c.setMemory(memory);

        //运行计算机
        c.run();
    }
}
