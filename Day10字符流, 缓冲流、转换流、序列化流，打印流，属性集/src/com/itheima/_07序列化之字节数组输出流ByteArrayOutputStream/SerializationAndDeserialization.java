package com.itheima._07序列化之字节数组输出流ByteArrayOutputStream;

import com.itheima._07序列化.User;

import java.io.*;

/**
     目标:ByteArrayOutputStream （字节数组输出流，低级流）避开了序列化和反序列化，
          不用跟硬盘交互，直接内存操作，节省了资源和缩短了响应时间

     对象序列化：就是把Java对象数据直接存储到文件中去。           对象 => 文件中
     对象反序列化：就是把Java对象的文件数据恢复到Java对象中。     文件中 => 对象

                   字节流                                    字符流
     字节输入流               字节输出流              字符输入流          字符输出流
     InputStream             OutputStream          Reader             Writer   (抽象类)
     FileInputStream         FileOutputStream      FileReader         FileWriter(实现类)
     BufferedInputStream     BufferedOutputStream  BufferedReader     BufferedWriter(实现类，缓冲流)
                                                   InputStreamReader  OutputStreamWriter
     ObjectInputStream       ObjectOutputStream

     对象序列化流（对象字节输出流）：ObjectOutputStream
         -- 作用：把内存中的Java对象数据保存到文件中去。
         -- 构造器：   public ObjectOutputStream(OutputStream out)
         -- 序列化方法：public final void writeObject(Object obj)

     对象反序列化流（对象字节输入流）：ObjectInputStream
         -- 作用：读取序列化的对象文件恢复到Java对象中。
         -- 构造器：public ObjectInputStream(InputStream is)
         -- 方法：public final Object readObject()

     注意：对象如果想参与序列化，对象必须实现序列化接口 implements Serializable ，否则序列化失败！
          如果一个字段不想参数序列化：
                                    TODO： transient修饰该成员变量，它将不参与序列化！
          序列化版本号：
                // 加入序列版本号
                private static final long serialVersionUID = 2L;
                必须序列化使用的版本号和反序列化使用的版本号一致才可以正常反序列化！否则报错！

    小结：
         注意：对象如果想参与序列化，对象必须实现序列化接口 implements Serializable ，否则序列化失败！
         对象序列化使用的流是对象字节输出流：ObjectOutputStream
         对象反序列化可以把对象序列化的文件数据恢复成Java对象。
         对象反序列化使用的流是：ObjectInputStream.
 */
public class SerializationAndDeserialization {
    public static void main(String[] args) throws Exception {
        // 1.创建User用户对象
        User user = new User("tsgz","003197","铁扇公主");
        // 2.创建低级的字节数组输出流无需通向目标文件
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 3.把低级的字节数组输出流包装成高级的对象字节输出流ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        // 4.通过对象字节输出流序列化对象：
        oos.writeObject(user);
        System.out.println("序列化对象成功~~~~");

        // 1.定义一个低级的字节数组输入流,传入字节数组输出流中的byte数组
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        // 2.把低级的字节数组输入流包装成高的对象字节输入流
        ObjectInputStream ois = new ObjectInputStream(bis);
        // 3.反序列化
        User user1 = (User) ois.readObject();

        System.out.println(user1);
        System.out.println("反序列化完成！");
    }
}
