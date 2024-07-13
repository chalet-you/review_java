package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._22原型设计模式Prototype之深克隆实现方式2序列化反序列化推荐使用;

import java.io.*;

/**
    深克隆（又称递归克隆）：
          一：对基本数据类型进行值传递，对引用数据类型，创建一个新的对象，并复制其内容，此为深拷贝
          二：也就是说浅拷贝对于子对象只是拷贝了引用值，并没有真正的拷贝整个对象
          三：为所有引用数据类型的成员变量申请存储空间，并复制每个引用数据类型成员变量所引用的对象，直到该对象可达的所有对象。
          也就是说，对象进行深拷贝要对整个对象进行拷贝
          三：深拷贝实行方式一：重写clone方法来实现深拷贝
          四：深拷贝实行方式二：通过对象序列化实现深拷贝（推荐）

    实现深克隆方式一：
          利用序列化。【先对对象进行序列化，紧接着马上反序列化出 】
          这里使用 ByteArrayOutputStream （字节数组输出流，低级流）避开了序列化和反序列化，
         不用跟硬盘交互，直接内存操作，节省了资源和缩短了响应时间
 */
public class CitaionTest {
    public static void main(String[] args) throws Exception {
        //1，创建原型对象
        Citation citation1 = new Citation();
        //创建张三学生对象
        Student stu = new Student();
        stu.setName("张三");
        citation1.setStu(stu);

        //创建字节数组输出流对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        //写对象
        oos.writeObject(citation1);

        //创建字节数组输入流对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        //创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(bis);
        //读取对象
        Citation citation2 = (Citation) ois.readObject();
        //释放资源
        ois.close();
        Student stu1 = citation2.getStu();
        stu1.setName("李四");


        //3,调用show方法展示
        citation1.show();
        citation2.show();

        //4,分别打印两个奖状对象和学生对象的哈希值
        System.out.println(citation1.hashCode()+"---->"+citation1.getStu().hashCode());
        System.out.println(citation2.hashCode()+"--->"+citation2.getStu().hashCode());
    }
}
