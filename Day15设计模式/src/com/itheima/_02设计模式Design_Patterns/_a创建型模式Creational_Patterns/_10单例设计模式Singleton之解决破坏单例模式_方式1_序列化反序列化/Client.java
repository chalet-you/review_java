package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._10单例设计模式Singleton之解决破坏单例模式_方式1_序列化反序列化;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description:
 *      测试使用序列化破坏单例模式
 *
 *      桌面路径： Day15设计模式\src\singleton.dat
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) throws Exception {
//        writeObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    //从文件读取数据（对象）
    public static void readObjectFromFile() throws Exception {
        //1,创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Day15设计模式\\src\\singleton.dat"));
        //2,读取对象
        Singleton instance = (Singleton) ois.readObject();

        System.out.println(instance);

        //释放资源
        ois.close();
    }

    //向文件中写数据（对象）
    public static void writeObject2File() throws Exception {
        //1,获取Singleton对象
        Singleton instance = Singleton.getInstance();
        //2,创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Day15设计模式\\src\\singleton.dat"));
        //3,写对象
        oos.writeObject(instance);
        //4,释放资源
        oos.close();
    }
}
