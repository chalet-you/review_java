package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._08桥接设计模式Bridge之案例二;

/**
     需求：需要开发一个跨平台视频播放器，可以在不同操作系统平台（如Windows、Mac、Linux等）
          上播放多种格式的视频文件，常见的视频格式包括RMVB、AVI、WMV等。该播放器包含了两个维度，
          适合使用桥接模式
 */
public class Client {
    public static void main(String[] args) {
        OperatingSystemVersion mac = new Mac(new RMVBFile());
        mac.play("阿凡达");

        OperatingSystemVersion windows = new Windows(new AVIFile());
        windows.play("苍老师全集");
    }
}
