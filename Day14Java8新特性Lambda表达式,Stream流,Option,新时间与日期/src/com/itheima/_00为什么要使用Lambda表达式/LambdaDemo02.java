package com.itheima._00为什么要使用Lambda表达式;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
      目标：为什么要使用Lambda表达式

      传统Java对于集合的操作，如果条件发生变化，需要重新定义一个方法，每个方法中代码过于冗余，而且也繁琐。
      那有没有优化代码的方式呢？
      解决方案：
      1、使用策略设设计模式优化代码
      2、使用匿名内部类优化代码
      3、使用Lambda表达式优化代码
 */
public class LambdaDemo02 {
    // 定义一个List集合用于存储公司员工对象
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 59, 6666.66),
            new Employee("王五", 28, 3333.33),
            new Employee("赵六", 8, 7777.77),
            new Employee("田七", 38, 5555.55)
    );

    @Test
    public void test1(){

        // TODO 需求1：获取当前公司中员工年龄大于35岁的员工信息
        List<Employee> emps1 = filterEmployeeAge(employees);
        for (Employee employee : emps1) {
            System.out.println(employee);
        }
        System.out.println("------------------------------------");

        // TODO 需求2：获取公司中工资大于 5000 的员工信息
        List<Employee> emps2 = filterEmployeeSalary(employees);
        for (Employee employee : emps2) {
            System.out.println(employee);
        }

    }

    /**
     * 定义一个特有方法：要求年龄大于35的员工
     * @param emps
     * @return
     */
    public static List<Employee> filterEmployeeAge(List<Employee> emps){
        List<Employee> lists = new ArrayList<>();
        for (Employee emp : emps) {
            if (emp.getAge() > 35){
                lists.add(emp);
            }
        }
        return lists;
    }


    /**
     * 定义一个特有方法：要求薪水大于5000的员工
     * @param emps
     * @return
     */
    public static List<Employee> filterEmployeeSalary(List<Employee> emps){
        List<Employee> lists = new ArrayList<>();
        for (Employee emp : emps) {
            if (emp.getSalary() >5000){
                lists.add(emp);
            }
        }
        return lists;
    }
}
