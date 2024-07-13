package com.itheima._10CommonsIO包介绍;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
    目标:Commons-io包的使用介绍。

    什么是Commons-io包？
            commons-io是apache开源基金组织提供的一组有关IO操作的类库，目的简化原始IO流操作的
            可以挺提高IO功能开发的效率。commons-io工具包提供了很多有关io操作的类，
    见下表：
         | 包                                  | 功能描述                                     |
         | ----------------------------------- | :------------------------------------------- |
         | org.apache.commons.io               | 有关Streams、Readers、Writers、Files的工具类 |
         | org.apache.commons.io.input         | 输入流相关的实现类，包含Reader和InputStream  |
         | org.apache.commons.io.output        | 输出流相关的实现类，包含Writer和OutputStream |
         | org.apache.commons.io.serialization | 序列化相关的类
    步骤：
         1. 下载commons-io相关jar包；http://commons.apache.org/proper/commons-io/
         2. 把commons-io-2.6.jar包复制到指定的Module的lib目录中
         3. 将commons-io-2.6.jar加入到classpath中

    API介绍：
            org.apache.commons.io.IOUtils，封装了大量IO读写操作的代码。其中有两个常用方法
            public static int copy(InputStream in, OutputStream out)；
                  -- 把input输入流中的文件内容拷贝到output输出流中，返回拷贝的字节个数(适合文件大小为2GB以下)
            public static long copyLarge(InputStream in, OutputStream out)；
                  -- 把input输入流中的文件内容拷贝到output输出流中，返回拷贝的字节个数(适合文件大小为2GB以上)
            org.apache.commons.io.FileUtils，封装了一些对文件操作的方法
            public static void copyFileToDirectory(final File srcFile, final File destFile)
                  -- 复制文件到另外一个目录下（目标目录会自动创建）
            public static void copyDirectoryToDirectory( file1 , file2 );
                  -- 复制file1目录到file2目录位置
    小结：
        IOUtils和FileUtils可以方便的复制文件和文件夹！！
 */
public class CommonsIODemo01 {
    public static void main(String[] args) throws Exception {
        // 1.完成文件复制！
        IOUtils.copy(new FileInputStream("Day13XML和Dom4j，装饰模式，工厂模式，commons-io工具包，Base64/src/books.xml"), new FileOutputStream("Day13XML和Dom4j，装饰模式，工厂模式，commons-io工具包，Base64/new.xml"));
        // 2.完成文件复制到某个文件夹下！
        FileUtils.copyFileToDirectory(new File("Day13XML和Dom4j，装饰模式，工厂模式，commons-io工具包，Base64/src/books.xml"), new File("F:/datas"));
        // 3.完成文件夹复制到某个文件夹下！
        FileUtils.copyDirectoryToDirectory(new File("F:\\datas\\约吧图片服务器") , new File("F:\\"));

        //  Java从1.7开始提供了一些nio, 自己也有一行代码完成复制的技术。
        Files.copy(Paths.get("Day13XML和Dom4j，装饰模式，工厂模式，commons-io工具包，Base64/src/books.xml")
                , new FileOutputStream("Day13XML和Dom4j，装饰模式，工厂模式，commons-io工具包，Base64/new11.txt"));
    }
}
