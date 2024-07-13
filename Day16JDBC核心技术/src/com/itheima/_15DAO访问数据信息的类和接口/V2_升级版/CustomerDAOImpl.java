package com.itheima._15DAO访问数据信息的类和接口.V2_升级版;



import com.itheima._15DAO访问数据信息的类和接口.V1_基础版.bean.Customer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;



public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO{
	
	
	@Override
	public void insert(Connection conn, Customer cust) {
		String sql = "insert into test.customers(name,email,birth)values(?,?,?)";
		update(conn, sql,cust.getName(),cust.getEmail(),cust.getBirth());
	}

	@Override
	public void deleteById(Connection conn, int id) {
		String sql = "delete from test.customers where id = ?";
		update(conn, sql, id);
	}

	@Override
	public void update(Connection conn, Customer cust) {
		String sql = "update test.customers set name = ?,email = ?,birth = ? where id = ?";
		update(conn, sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
	}

	@Override
	public Customer getCustomerById(Connection conn, int id) {
		String sql = "select id,name,email,birth from test.customers where id = ?";
		Customer customer = getInstance(conn, sql,id);
		return customer;
	}

	@Override
	public List<Customer> getAll(Connection conn) {
		String sql = "select id,name,email,birth from test.customers";
		List<Customer> list = getForList(conn, sql);
		return list;
	}

	@Override
	public Long getCount(Connection conn) {
		String sql = "select count(*) from test.customers";
		return getValue(conn, sql);
	}

	@Override
	public Date getMaxBirth(Connection conn) {
		String sql = "select max(birth) from test.customers";
		return getValue(conn, sql);
	}

}
