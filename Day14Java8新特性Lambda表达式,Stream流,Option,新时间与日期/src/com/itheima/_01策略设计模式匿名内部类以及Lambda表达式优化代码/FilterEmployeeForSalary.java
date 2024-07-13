package com.itheima._01策略设计模式匿名内部类以及Lambda表达式优化代码;

import com.itheima._00为什么要使用Lambda表达式.Employee;

public class FilterEmployeeForSalary implements MyPredicate<Employee> {


	@Override
	public boolean filter(Employee t) {
		return t.getSalary() >= 5000;
	}

}
