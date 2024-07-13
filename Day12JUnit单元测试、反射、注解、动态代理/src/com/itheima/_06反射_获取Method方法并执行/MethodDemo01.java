package com.itheima._06反射_获取Method方法并执行;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
    目标：反射——获取Method方法对象

    反射获取类的Method方法对象：
         1、Method getMethod(String name,Class...args);
             根据方法名和参数类型获得对应的方法对象，只能获得public的

         2、Method getDeclaredMethod(String name,Class...args);
             根据方法名和参数类型获得对应的方法对象，包括private的

         3、Method[] getMethods();
             获得类中的所有成员方法对象，返回数组，只能获得public修饰的且包含父类的

         4、Method[] getDeclaredMethods();
            获得类中的所有成员方法对象，返回数组,只获得本类申明的方法。

    Method的方法执行：
        Object invoke(Object obj, Object... args)
          参数一：触发的是哪个对象的方法执行。
          参数二： args：调用方法时传递的实际参数
 */
public class MethodDemo01 {
    /**
     * 1.获得类中的所有成员方法对象
     */
    @Test
    public void getDeclaredMethods(){
        // a.先获取class类对象
        Class c = Dog.class ;
        // b.获取全部申明的方法!
        Method[] methods = c.getDeclaredMethods();
        // c.遍历这些方法
//        for (Method method : methods) {
//            // 获取方法的名称
//            System.out.println(method.getName()+"====>"
//                    // 获取方法的参数列表
//                    + Arrays.toString(method.getParameterTypes())+"===>"
//                    // 获取方法的参数列表个数
//                    + method.getParameterCount()+"===>"
//                    // 获取方法的返回值类型，简名
//                    + method.getReturnType().getSimpleName()+"===>"
//                    // 获取方法的修饰符
//                    + Modifier.toString(method.getModifiers()));
//        }
        // c.遍历这些方法
        for (Method method : methods) {
            // 获取方法的修饰符
            String mod = Modifier.toString(method.getModifiers());
            System.out.print(mod + " ");
            // 获取方法的返回值类型，简名
            String returnType = method.getReturnType().getSimpleName();
            System.out.print(returnType + " ");
            // 获取方法的名称
            System.out.print(method.getName() +"(");
            // 获取方法的参数列表
            Class<?>[] ps = method.getParameterTypes();
            if (ps.length == 0) System.out.print(")");
            for (int i = 0; i < ps.length; i++) {
                char end = (i == ps.length - 1) ? ')' : ',';
                // 获取参数的类型
                System.out.print(ps[i].getSimpleName() + end);
            }
            System.out.println();
        }

    }
    /**
     * 2. 获取某个方法对象
     */
    @Test
    public void getDeclardMethod() throws Exception {
        // a.先获取class类对象
        Class c = Dog.class;
        // b.定位它的某个方法
        Method run = c.getDeclaredMethod("run");
        // c.触发方法执行!
        Dog jinMao = new Dog();
        Object rs = run.invoke(jinMao); // 触发jinMao对象的run()方法执行！
        System.out.println(rs);// 如果方法没有返回值，结果是null

        /**
         * 参数一：方法名称
         * 参数二：方法的参数个数和类型(可变参数！)
         */
        Method eat = c.getDeclaredMethod("eat",String.class);
        eat.setAccessible(true); // 暴力反射！
        /**
         * 参数一：被触发方法所在的对象
         * 参数二：方法需要的入参值
         */
        Object rs1 = eat.invoke(jinMao,"肉");
        System.out.println(rs1);// 如果方法没有返回值，结果是null
    }

    /**
     * 2. 获取某个静态方法对象
     */
    @Test
    public void getDeclaredStaticMethod() throws Exception {
        // a.先获取class类对象
        Class c = Dog.class;
        // b.定位它的某个静态的方法
        Method inAddr = c.getDeclaredMethod("inAddr");
        // c.触发静态方法执行!可以传Class的类对象，因为静态方法属于类本身的，也可以传某个Dog对象，因为静态方法是被每个对象共享的
        Dog jinMao = new Dog();
        inAddr.invoke(c);
        inAddr.invoke(jinMao);
    }
}