package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._08桥接设计模式Bridge之案例二;

public class Windows extends OperatingSystemVersion {
    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
