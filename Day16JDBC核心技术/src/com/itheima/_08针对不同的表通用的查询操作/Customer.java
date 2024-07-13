package com.itheima._08针对不同的表通用的查询操作;

import java.sql.Date;

/*
 * ORM编程思想  （object relational mapping）
 * 一个数据表        对应   java一个类
 * 表中的一条记录    对应   java类的一个对象
 * 表中的一个字段    对应   java类的一个属性
 * 
 */
public class Customer {
	
	private int id;
	private String name;
	private String email;
	private Date birth;
	public Customer() {
		super();
	}
	public Customer(int id, String name, String email, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", birth=" + birth + "]";
	}
	
	
	
}
