package com.itheima._01策略设计模式匿名内部类以及Lambda表达式优化代码;


import com.itheima._00为什么要使用Lambda表达式.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
     目标：策略设计模式优化代码

    步骤：
         1、先定义一个接口，在接口中再定义一个抽象方法，不具体实现策略细节。
         2、再定义一个过滤员工年龄的实现类实现该接口，重写过滤年龄条件的具体方法。
         3、再定义一个过滤员工薪水的实现类实现该接口，重写过滤薪水条件的具体方法。
         4、在测试类Demo中，定义一个方法filterEmployee，以存储员工对象的集合，和策略接口入参，以新的员工集合为返回值。
            当需要实现什么策略的话，就具体传入具体的策略类对象，这样就可以定义一个方法就可以实现多种过滤条件。。。
    缺点：
         需要写多个策略实现类类去实现接口。


 */
public class LambdaDemo01 {

    // 定义一个List集合用于存储公司员工对象
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 59, 6666.66),
            new Employee("王五", 28, 3333.33),
            new Employee("赵六", 8, 7777.77),
            new Employee("田七", 38, 5555.55)
    );

        // TODO 需求1：获取当前公司中员工年龄大于35岁的员工信息
        // TODO 需求2：获取公司中工资大于 5000 的员工信息
    @Test
    public void test1(){

        List<Employee> emps1 = filterEmployee(employees, new FilterEmployeeForAge());
        for (Employee employee : emps1) {
            System.out.println(employee);
        }
        System.out.println("------------------------------------");

        List<Employee> emps2 = filterEmployee(employees, new FilterEmployeeForSalary());
        for (Employee employee : emps2) {
            System.out.println(employee);
        }
    }

    /**
     * 定义一个特有方法：过滤各种条件的员工，具体过滤的条件由实现类自己完成
     * @param emps
     * @param predicate
     * @return
     */
    public static List<Employee> filterEmployee(List<Employee> emps,MyPredicate<Employee> predicate){
        List<Employee> lists = new ArrayList<>();
        for (Employee emp : emps) {
            if (predicate.filter(emp)){
                lists.add(emp);
            }
        }
        return lists;
    }

}
