package com.itheima._08反射有啥用;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Mybatis {
    // 提供一个方法：可以保存一切对象数据的字段和具体值
    public static void save(Object obj) {
        try(
                PrintStream ps =
                        new PrintStream(new FileOutputStream("Day12JUnit单元测试、反射、注解、动态代理/src/datas.txt",true));
          ){
            // 解析对象的字段和每个字段的值存储起来！
            // obj = Student/Pig/Teacher....
            // 1.先得到对象的Class文件对象
            Class c = obj.getClass();
            ps.println("========="+c.getSimpleName()+"===========");
            // 2.定位它的全部成员变量
            Field[] fields = c.getDeclaredFields();
            // 3.遍历这些字段并且取值
            for (Field field : fields) {
                // 字段名称
                String name = field.getName();
                // 字段的值
                field.setAccessible(true); // 暴力反射！不建议：可以通过get方法获取成员变量的值
                String value = field.get(obj)+"";
                ps.println(name+"="+value);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    // 提供一个方法：可以保存一切对象数据的字段和具体值
    public static void save1(Object obj) {
        try(
                PrintStream ps =
                        new PrintStream(new FileOutputStream("Day12JUnit单元测试、反射、注解、动态代理/src/datas.txt",true));
        ){
            // 解析对象的字段和每个字段的值存储起来！
            // obj = Student/Pig/Teacher....
            // 1.先得到对象的Class文件对象
            Class c = obj.getClass();
            ps.println("========="+c.getSimpleName()+"===========");
            // 2.定位它的全部方法并过滤出带get关键字的方法
            Method[] methods = c.getDeclaredMethods();
            // 3.遍历这些方法并取出方法的返回值
            for (Method method : methods) {
                String methodName = method.getName();
                if (methodName.contains("get")){
                    String fieldName = methodName.substring(3).toLowerCase();
                    String fieldValue = method.invoke(obj) + "";
                    ps.println(fieldName +" = "+fieldValue);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
