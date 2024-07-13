package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._21原型设计模式Prototype之深克隆实现方式1;

/**
     深克隆（又称递归克隆）：
            一：对基本数据类型进行值传递，对引用数据类型，创建一个新的对象，并复制其内容，此为深拷贝
            二：也就是说浅拷贝对于子对象只是拷贝了引用值，并没有真正的拷贝整个对象
            三：为所有引用数据类型的成员变量申请存储空间，并复制每个引用数据类型成员变量所引用的对象，直到该对象可达的所有对象。
               也就是说，对象进行深拷贝要对整个对象进行拷贝
            三：深拷贝实行方式一：重写clone方法来实现深拷贝
            四：深拷贝实行方式二：通过对象序列化实现深拷贝（推荐）

     实现深克隆方式一：
            对于每个子对象都实现Cloneable 接口，并重写clone方法。
            最后在最顶层的类的重写的 clone 方法中调用所有子对象的 clone 方法即可实现深拷贝。
          【简单的说就是：每一层的每个子对象都进行浅拷贝=深拷贝】
 */
public class CitaionTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //1，创建原型对象
        Citation citation1 = new Citation();
        //创建张三学生对象
        Student stu = new Student();
        stu.setName("张三");
        citation1.setStu(stu);

        //2,克隆奖状对象
        Citation citation2 = citation1.clone();
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
