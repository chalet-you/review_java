package com.itheima._16Path和Paths概述;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
    目标：Path接口的概述和API

    Path是一个接口，是Java NIO 更新的一部分，Path的完全限定名称是 java.nio.file.Path

    Path的实例表示文件系统中的路径。一个路径可以指向一个文件或一个目录。
    路径 可以是绝对路径，也可以是相对路径。
    绝对路径包含从文件系统的根目录到它指向的文件或目录的完整路径。
    相对路径包含相对于其他路径的文件或目录的路径

    在许多方面，java.nio.file.Path 接口类似于 java.io.File 类，但是有一些差别。
    不过，在许多情况下，可以使用 Path 接口来替换 File 类的使用。

    使用 Path 实例必须创建一个 Path 实例。可以使用 Paths 类(java.nio.file.Paths)中的静态方法 Paths.get()来创建路径实例

    Path接口的实例创建的方式的API:
         （1）可以使用 Paths 类(java.nio.file.Paths)中的静态方法 Paths.get()来创建路径实例。
              --  public static Path get(String first, String... more){}

    Path接口的API：
         （1）Path 接口的 normalize()方法可以使路径标准化。
             标准化意味着它将移除所有在路径字符串的中间的 . 和 .. 代码，并解析路径字符串所引用的路径
              -- Path.normalize()


 */
public class PathDemo01 {
    public static void main(String[] args) {
        // TODO 创建Path的实例
        // 1.通过绝对路径创建Path的实例
        Path path1 = Paths.get("F:\\datas\\data\\1.txt");

       // 2.通过相对路径创建Path的实例
        Path path2 = Paths.get("F:\\datas\\data", "test");


        Path path3 = Paths.get("F:\\datas\\data", "test\\1.txt");

        // TODO Path.normalize()方法可以使路径标准化。
        /**
            标准化意味着它将移除所有在路径字符串的中间的.和..代码，并解析路径字符串所引用的路径。
         */
        String originalPath = "F:\\datas\\data\\..\\图片资源";

        Path path4 = Paths.get(originalPath);
        System.out.println("path4 = " + path4);

        Path path5 = path4.normalize();
        System.out.println("path5 = " + path5);

    }
}
