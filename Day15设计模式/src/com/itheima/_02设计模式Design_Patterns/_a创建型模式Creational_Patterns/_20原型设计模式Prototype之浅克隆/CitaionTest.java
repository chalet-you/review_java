package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._20原型设计模式Prototype之浅克隆;

/**
    浅克隆：
          一：对于数据类型是基本数据类型和String类型的成员变量，浅拷贝会直接进行值传递，
             也就是将该属性值复制一份给新的对象（克隆对象）。
          二：对于数据类型是引用数据类型的成员变量，比如说成员变量是某个数组、某个类的对象等，
             那么浅拷贝会进行引用传递，也就是只是将该成员变量的引用值（内存地址）复制一份给新的对象。
             因为实际上两个对象的该成员变量都指向同一个实例。在这种情况下，在一个对象中修改该成员变量
             会影响到另一个对象的该成员变量值
          三：浅拷贝是使用默认的clone()方法实现 Object obj = super.clone();
 */
public class CitaionTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //1，创建原型对象
        Citation citation = new Citation();
        //创建张三学生对象
        Student stu = new Student();
        stu.setName("张三");
        citation.setStu(stu);

        //2,克隆奖状对象
        Citation citation1 = citation.clone();
        Student stu1 = citation1.getStu();
        stu1.setName("李四");

        /*citation.setName("张三");
        citation1.setName("李四");*/

        //3,调用show方法展示
        citation.show();
        citation1.show();

        //4,分别打印两个奖状对象和学生对象的哈希值
        System.out.println(citation.hashCode()+"---->"+citation.getStu().hashCode());
        System.out.println(citation1.hashCode()+"--->"+citation1.getStu().hashCode());
    }
}
