package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._08桥接设计模式Bridge之案例二;

public abstract class OperatingSystemVersion {
    protected VideoFile videoFile;

    public OperatingSystemVersion(VideoFile videoFile) {
        this.videoFile = videoFile;
    }
    public abstract void play(String fileName);
}
