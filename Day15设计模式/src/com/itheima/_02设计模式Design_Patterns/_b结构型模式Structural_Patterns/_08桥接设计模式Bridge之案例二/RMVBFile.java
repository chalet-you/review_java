package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._08桥接设计模式Bridge之案例二;

public class RMVBFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("rmvb视频文件："+ fileName);
    }
}
