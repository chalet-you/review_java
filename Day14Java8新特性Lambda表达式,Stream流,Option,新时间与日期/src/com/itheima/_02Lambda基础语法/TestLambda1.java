package com.itheima._02Lambda基础语法;


import com.itheima._00为什么要使用Lambda表达式.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda1 {
    List<Employee> employees = Arrays.asList(
            new Employee("zhangsan", 18, 9999.99),
            new Employee("lisi", 59, 6666.66),
            new Employee("wangwu", 18, 3333.33),
            new Employee("zhaoliu", 18, 7777.77),
            new Employee("tianqi", 38, 5555.55)
    );

    @Test
    public void test1() {
        Collections.sort(employees, (emp1, emp2) -> {
            if (emp1.getAge() == emp2.getAge()) {
                return emp1.getName().compareTo(emp2.getName());
            } else {
                return Integer.compare(emp1.getAge(), emp2.getAge());
            }
        });

        employees.forEach(System.out::println);

    }

    @Test
    public void test2() {
        String result = strHandler("abcdef", str -> str.toUpperCase());
        System.out.println(result);

        String res = strHandler("\t\t\t我是谁我在哪里   ", str -> str.trim());
        System.out.println(res);

        System.out.println(strHandler("我的名字是叫尤选威武", str -> str.substring(6, 8)));
    }

    public String strHandler(String str, MyFunction2 my) {
        return my.getValue(str);

    }



    @Test
    public void test3() {
        System.out.println(op(100L, 200L, (x, y) -> x + y));
        System.out.println(op(999L, 888L, (x, y) -> x * y));
    }

    public long op(long l1, long l2, MyFunction3<Long, Long> my) {
        return my.getValue(l1, l2);
    }

    //需求：对一个数进行运算
    @Test
    public void test4(){
        Integer num = operation(100, x -> x * x);
        System.out.println(num);

        System.out.println(operation(200, y -> y + 200));
    }

    public Integer operation(Integer num, MyFunction1 mf){
        return mf.getValue(num);
    }
}
