package com.itheima._17单例模式之Runtime源码介绍;

import java.io.*;

/**
     public class Runtime {
         // 定义一个静态成员并初始化
         private static Runtime currentRuntime = new Runtime();

         // 定义一个对外访问的静态方法，用于返回Runtime类的单例对象
         public static Runtime getRuntime() {
             return currentRuntime;
         }

         // 构造器私有
         private Runtime() {}
                ...
     }
 */
public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        //获取Runtime类的对象
        Runtime runtime = Runtime.getRuntime();

//        //返回 Java 虚拟机中的内存总量。
//        System.out.println(runtime.totalMemory());
//        System.out.println("======================");
//
//        //返回 Java 虚拟机试图使用的最大内存量。
//        System.out.println(runtime.maxMemory());
//        System.out.println("======================");

        //调用runtime的方法exec, 参数要的是一个命令
        Process process = runtime.exec("ipconfig");
        //调用process对象的获取输入流的方法
        InputStream is = process.getInputStream();
        // 通过字符输入转换流，把指定编码把字节输入流转换成字符输入流
        Reader isr = new InputStreamReader(is,"GBK"); // 指定编码把字节流转换成字符流
        // 把普通的字符输入流包装成缓冲字符输入流
        BufferedReader br = new BufferedReader(isr);
        // 定义一个字符串变量存储每行数据
        String line;
        while ((line = br.readLine()) != null){
            // 使用一个循环读取数据(经典代码)
            System.out.println(line);
        }

        // todo：给一个软件的启动文件的绝对路径，可以启动一个软件
        runtime.exec("D:\\develop\\SecureCRT\\SecureCRT.exe");


    }
}
