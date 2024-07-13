package com.itheima._28字节流做文件复制;

import java.io.*;

/**
    目标：字节流做文件复制。

    字节流复制的思想：
        字节是计算机中一切文件的组成，所以
        字节流适合做一切文件的复制。
        复制是把源文件的全部字节一字不漏的转移到目标文件，只要文件前后的格式一样，绝对不会有问题。

    需求：
        原文件：D:\datas\图片资源\meinv.jpg
        目标文件：D:\datas\meimei.jpg
    分析步骤：
        （1）创建一个字节输入流管道与源文件接通。
        （2）创建一个字节输出流与目标文件接通。
        （3）创建一个字节数组作为桶
        （4）从字节输入流管道中读取数据，写出到字节输出流管道即可。
        （5）关闭资源！
 */
public class CopyDemo01 {
    public static void main(String[] args) {
        InputStream is = null ;
        OutputStream os = null ;
        try{
            //** （1）创建一个字节输入流管道与源文件接通。
            is = new FileInputStream("F:\\datas\\图片资源\\meimei.jpg");
            //** （2）创建一个字节输出流与目标文件接通。
            os = new FileOutputStream("F:\\datas\\meimei.jpg");
            //** （3）创建一个字节数组作为桶
            byte[] buffer = new byte[1024];
            //** （4）从字节输入流管道中读取数据，写出到字节输出流管道即可。
            int len ;
            while((len = is.read(buffer)) != -1){
                // 读取多少就倒出多少
                os.write(buffer, 0 , len);
            }
            System.out.println("复制完成！");
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            //**（5）关闭资源！

                if(os!=null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(is!=null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

        }
    }
}
