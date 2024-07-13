package com.itheima._01策略设计模式匿名内部类以及Lambda表达式优化代码;


import com.itheima._00为什么要使用Lambda表达式.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
     目标：终极目的使用Stream的流式编程，Java已经内置类一些函数式接口




 */
public class LambdaDemo04 {

    // 定义一个List集合用于存储公司员工对象
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 59, 6666.66),
            new Employee("王五", 28, 3333.33),
            new Employee("赵六", 8, 7777.77),
            new Employee("田七", 38, 5555.55)
    );

        // TODO 需求1：获取当前公司中员工年龄大于35岁的员工信息
        // TODO 需求2：获取公司中工资最高的前2名员工的姓名
    @Test
    public void test1(){
        employees.stream()
        .filter(employee -> employee.getAge() > 30)
        .forEach(System.out::println);

        System.out.println("--------------------------------------");
        employees.stream()
                .sorted((emp1, emp2) -> - Double.compare(emp1.getSalary(),emp2.getSalary()))
                .limit(2)
                .forEach(System.out::println);
    }


}
