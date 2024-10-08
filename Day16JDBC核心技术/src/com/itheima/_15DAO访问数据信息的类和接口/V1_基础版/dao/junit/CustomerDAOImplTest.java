package com.itheima._15DAO访问数据信息的类和接口.V1_基础版.dao.junit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;


import com.itheima._15DAO访问数据信息的类和接口.V1_基础版.bean.Customer;
import com.itheima._15DAO访问数据信息的类和接口.V1_基础版.dao.CustomerDAOImpl;
import com.itheima._19使用数据库连接池技术封装连接和关闭操作JDBCUtils.JDBCUtils;
import org.junit.Test;


public class CustomerDAOImplTest {

	private CustomerDAOImpl dao = new CustomerDAOImpl();
	
	@Test
	public void testInsert() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			Customer cust = new Customer(1, "于小飞", "xiaofei@126.com",new Date(43534646435L));
			dao.insert(conn, cust);
			System.out.println("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
		
	}

	@Test
	public void testDeleteById() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			
			dao.deleteById(conn, 13);
			
			
			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
	}

	@Test
	public void testUpdateConnectionCustomer() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			Customer cust = new Customer(18,"贝多芬","beiduofen@126.com",new Date(453465656L));
			dao.update(conn, cust);
			
			
			System.out.println("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
	}

	@Test
	public void testGetCustomerById() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection3();
			
			Customer cust = dao.getCustomerById(conn, 18);
			System.out.println(cust);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
	}

	@Test
	public void testGetAll() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			
			List<Customer> list = dao.getAll(conn);
			list.forEach(System.out::println);
			
			
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
	}

	@Test
	public void testGetCount() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			
			Long count = dao.getCount(conn);
			
			System.out.println("表中的记录数为：" + count);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
	}

	@Test
	public void testGetMaxBirth() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			
			Date maxBirth = dao.getMaxBirth(conn);
			
			System.out.println("最大的生日为：" + maxBirth);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
	}

}
