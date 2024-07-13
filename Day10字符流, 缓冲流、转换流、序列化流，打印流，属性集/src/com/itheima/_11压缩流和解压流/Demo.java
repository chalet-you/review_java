package com.itheima._11压缩流和解压流;

import com.itheima._07序列化.User;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
     目标: GZIPOutputStream  压缩流。
           GZIPInputStream  解压流

     GZIPOutputStream：就是把文件压缩。
     GZIPInputStream ：就是把压缩的文件解压出

                   字节流                                    字符流
     字节输入流               字节输出流              字符输入流          字符输出流
     InputStream             OutputStream          Reader             Writer   (抽象类)
     FileInputStream         FileOutputStream      FileReader         FileWriter(实现类)
     BufferedInputStream     BufferedOutputStream  BufferedReader     BufferedWriter(实现类，缓冲流)
                                                   InputStreamReader  OutputStreamWriter
     GZIPInputStream       GZIPOutputStream

    压缩流：GZIPOutputStream
         -- 作用：把原始文件通过算法压缩成小文件。
         -- 构造器：   public GZIPOutputStream(OutputStream out)
         -- 压缩方法： public synchronized void write(byte[] buf, int off, int len)
    解压流：GZIPInputStream
         -- 作用：把已经压缩成小的文件重新解压出来
         -- 构造器：  public GZIPInputStream(InputStream in)
         -- 解压方法： public int read(byte[] buf)

     注意：如果当初用什么方式压缩的，解压应该也用当初那种方式解压

 */
public class Demo {
    public static void main(String[] args) {
        //zip();  // 压缩文件
        unZIP();  // 解压文件
    }

    // 压缩文件
    private static void zip() {
        try (
                // 1.创建压缩流对象并指定输出路径
                GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream("F:\\datas\\SogouQ.sample.zip"));
                // 2.创建字节字节输入流指定要被压缩的文件路径
                FileInputStream is = new FileInputStream("F:\\datas\\SogouQ.sample");
                )
        {
            // 3.开始用字节输入流读取文件，并用压缩流压缩文件
            byte[] buffer = new byte[1024*8];
            int len;
            while ((len = is.read(buffer)) != -1){
                gos.write(buffer,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("压缩成功~~~~");
    }

    //解压文件
    private static void unZIP(){
        try (
                // 1.创建解压流对象并指定输入路径
                GZIPInputStream gos = new GZIPInputStream(new FileInputStream("F:\\datas\\SogouQ.sample.zip"));
                // 2.创建字节字节输出流指定要解压后的文件路径
                FileOutputStream is = new FileOutputStream("F:\\datas\\SogouQ.sample");
        )
        {
            // 3.开始用字节输入流读取文件，并用压缩流压缩文件
            byte[] buffer = new byte[1024*8];
            int len;
            while ((len = gos.read(buffer)) != -1){
                is.write(buffer,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("解压成功~~~~");
    }
}
