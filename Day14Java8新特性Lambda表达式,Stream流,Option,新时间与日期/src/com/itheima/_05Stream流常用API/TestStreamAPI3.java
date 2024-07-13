package com.itheima._05Stream流常用API;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.Test;
//3. 终止操作
	/*  查询与匹配
	    allMatch     ---检查是否匹配所有元素
	    anyMatch     ---检查是否至少匹配一个元素
	    noneMatch    ---检查是否没有匹配所有元素
	    findFirst    ---返回第一个元素
	    findAny      ---返回当前流中的任意元素
	    count 		 ---返回流中元素的总个数
	    max 		 ---返回流中最大值
	    min 	     ---返回流中最小值


		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。

		收集
		collect ——可以将流转换为其他形式。接受一个Collector接口的实现，用于给Stream中元素做汇总的方法

		TODO 更多可以查看文档：https://blog.csdn.net/agonie201218/article/details/125563291
	 */

public class TestStreamAPI3 {
	
	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 79, 6666.66, Employee.Status.BUSY),
			new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
			new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
			new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
			new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
			new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
			new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY)
	);



	// 将元素以某种规则连接起来。该方法有两种重载 joining(CharSequence delimiter) 和
	// joining(CharSequence delimiter,CharSequence prefix,CharSequence suffix)
	// 分割符：delimiter
	// 前缀符：prefix
	// 后缀符：suffix
	@Test
	public void test9(){
		String str = emps.stream()
				.map(Employee::getName)
				.collect(Collectors.joining("," , "{", "}"));

		System.out.println(str);
	}



	// collect 分区
	@Test
	public void test8(){
		Map<Boolean, List<Employee>> map = emps.stream()
				.collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));

		System.out.println(map);
	}

	// collect 多级分组
	@Test
	public void test7(){
		Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
				.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
					if(e.getAge() >= 60)
						return "老年";
					else if(e.getAge() >= 35)
						return "中年";
					else
						return "成年";
				})));

		System.out.println(map);
	}


	// collect 一级分组
	@Test
	public void test6(){
		Map<Employee.Status, List<Employee>> map = emps.stream()
				.collect(Collectors.groupingBy(Employee::getStatus));

		System.out.println(map);
	}

	// collect 收集总数、总和、平均值、最大值、最小值
	@Test
	public void test5(){
		// 总数
		Long count = emps.stream()
				.collect(Collectors.counting());
		System.out.println(count);
		System.out.println("------------------------------------");

		// 工资的平均值
		Double avgSalary = emps.stream()
				.collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(avgSalary);
		System.out.println("------------------------------------");

		// 工资的总和
		Double sumSalary = emps.stream()
				.collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sumSalary);
		System.out.println("------------------------------------");

		// 最高工资
		Optional<Employee> maxSalary = emps.stream()
				.collect(Collectors.maxBy((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary())));

		System.out.println(maxSalary.get());
		System.out.println("------------------------------------");

		// 最低工资
		Optional<Double> minSalary = emps.stream()
				.map(Employee::getSalary)
				.collect(Collectors.minBy(Double::compare));

		System.out.println(minSalary.get());
		System.out.println("------------------------------------");



	}
	// collect
	@Test
	public void test4(){
		// 流 --> List集合
		List<String> nameLists = emps.stream()
				.map(Employee::getName)
				.collect(Collectors.toList());
		nameLists.forEach(System.out::println);
		System.out.println("------------------------------------");

		// 流 --> Set集合
		Set<Employee.Status> statusList = emps.stream()
				.map(Employee::getStatus)
				.collect(Collectors.toSet());

		statusList.forEach(System.out::println);
		System.out.println("------------------------------------");

		// 流 --> HashSet具体集合
		HashSet<String> nameHashSets = emps.stream()
				.map(Employee::getName)
				.collect(Collectors.toCollection(HashSet::new));
		nameHashSets.forEach(System.out::println);
	}



	// reduce
	@Test
	public void test3(){
		List<Integer> lists = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer sum = lists.stream().reduce(0, (x, y) -> x + y);
		System.out.println("sum = " + sum);

		Optional<Double> op = emps.stream()
				.map(Employee::getSalary)
				.reduce((a, b) -> BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).doubleValue());

		System.out.println(op.get());

	}

	@Test
    public void test2(){
		long count = emps.stream().count();
		System.out.println(count);

		Optional<Employee> op1 = emps.stream().max((emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary()));
		System.out.println(op1);

		Optional<Double> op2 = emps.stream()
				.map(Employee::getSalary)
				.min(Double::compareTo);
		System.out.println(op2);
	}

	@Test
	public void test1(){
		boolean b1 = emps.stream()
				.allMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
		System.out.println(b1);

		boolean b2 = emps.stream()
				.anyMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
		System.out.println(b2);

		boolean b3 = emps.stream()
				.noneMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
		System.out.println(b3);

		Optional<Employee> op = emps.stream()
				.sorted((emp1, emp2) ->- Double.compare(emp1.getSalary(), emp2.getSalary()))
				.findFirst();
		System.out.println(op.get());

		Optional<Employee> anyOp = emps.parallelStream()
				.filter(employee -> employee.getStatus().equals(Employee.Status.FREE))
				.findAny();

		System.out.println(anyOp.get());
	}

}
