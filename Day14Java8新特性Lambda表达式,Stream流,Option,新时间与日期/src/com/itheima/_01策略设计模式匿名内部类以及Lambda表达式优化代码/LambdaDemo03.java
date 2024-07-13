package com.itheima._01策略设计模式匿名内部类以及Lambda表达式优化代码;


import com.itheima._00为什么要使用Lambda表达式.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
     目标：Lambda优化代码

    缺点：
         需要自己写策略的接口。


 */
public class LambdaDemo03 {

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
        List<Employee> emp1 = filterEmployee(employees, employee -> employee.getAge() > 35);

        for (Employee employee : emp1) {
            System.out.println(employee);
        }

        System.out.println("------------------------------------");

        List<Employee> emp2 = filterEmployee(this.employees, employee -> employee.getSalary() > 5000);

        for (Employee employee : emp2) {
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
