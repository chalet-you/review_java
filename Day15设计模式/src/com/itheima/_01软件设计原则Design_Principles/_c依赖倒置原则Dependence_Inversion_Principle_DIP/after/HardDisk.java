package com.itheima._01软件设计原则Design_Principles._c依赖倒置原则Dependence_Inversion_Principle_DIP.after;

/**
 * @version v1.0
 * @ClassName: HardDisk
 * @Description: 硬盘接口
 * @Author: 黑马程序员
 */
public interface HardDisk {

    //存储数据
    public void save(String data);

    //获取数据
    public String get();
}
