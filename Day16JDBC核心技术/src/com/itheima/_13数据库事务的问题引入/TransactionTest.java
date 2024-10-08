package com.itheima._13数据库事务的问题引入;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.itheima._02使用Statement存在SQL注入问题.User;
import com.itheima._03JDBCUtils封装工具类数据库连接和关闭操作.JDBCUtils;
import org.junit.Test;


/*
 * 1.什么叫数据库事务？
 * 事务：一组逻辑操作单元,使数据从一种状态变换到另一种状态。
 * 		> 一组逻辑操作单元：可以理解为 一个或多个DML操作。
 * 
 * 2.事务处理的原则：保证所有事务都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式。
 * 当在一个事务中执行多个操作时，要么所有的事务都被提交(commit)，那么这些修改就永久地保存
 * 下来；要么数据库管理系统将放弃所作的所有修改，整个事务回滚(rollback)到最初状态。
 * 
 * 3.数据一旦提交，就不可回滚
 * 
 * 4.哪些操作会导致数据的自动提交？
 * 		>DDL操作一旦执行，都会自动提交。
 * 			>set autocommit = false 对DDL操作失效
 * 		>DML默认情况下，一旦执行，就会自动提交。
 * 			>我们可以通过set autocommit = false的方式取消DML操作的自动提交。
 * 		>默认在关闭连接时，会自动的提交数据
 */
public class TransactionTest {

	//TODO ********************考虑数据库事务后的转账操作*********************
	
	@Test
	public void testUpdateWithTx() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			//1. 获取原来数据库事务
			boolean commit = conn.getAutoCommit();//true
            //2.取消数据的自动提交
			conn.setAutoCommit(false);
			
			String sql1 = "update test.user_table set balance = balance - 100 where user = ?";
			update(conn,sql1, "AA");
			
			//模拟网络异常
			System.out.println(10 / 0);
			
			String sql2 = "update test.user_table set balance = balance + 100 where user = ?";
			update(conn,sql2, "BB");
			
			System.out.println("转账成功");
			
			//3.手动提交事务
			conn.commit();
			//4.还原原来事务
			conn.setAutoCommit(commit);

		} catch (Exception e) {
			e.printStackTrace();
			//3.回滚数据
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			JDBCUtils.closeResource(conn, null);
		}
		
	}
	
	//TODO 通用的增删改操作---version 2.0 （考虑上事务）
	public int update(Connection conn,String sql, Object... args) {// sql中占位符的个数与可变形参的长度相同！
		PreparedStatement ps = null;
		try {
			// 1.预编译sql语句，返回PreparedStatement的实例
			ps = conn.prepareStatement(sql);
			// 2.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);// 小心参数声明错误！！
			}
			// 3.执行
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.资源的关闭
			JDBCUtils.closeResource(null, ps);

		}
		return 0;

	}
	


	//TODO ******************未考虑数据库事务情况下的转账操作**************************
	/*
	 * 针对于数据表user_table来说：
	 * AA用户给BB用户转账100
	 *
	 * update user_table set balance = balance - 100 where user = 'AA';
	 * update user_table set balance = balance + 100 where user = 'BB';
	 */
	@Test
	public void testUpdate(){

		String sql1 = "update test.user_table set balance = balance - 100 where user = ?";
		update(sql1, "AA");

		//模拟网络异常
		System.out.println(10 / 0);

		String sql2 = "update test.user_table set balance = balance + 100 where user = ?";
		update(sql2, "BB");

		System.out.println("转账成功");
	}

	// 通用的增删改操作---version 1.0
	public int update(String sql, Object... args) {// sql中占位符的个数与可变形参的长度相同！
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1.获取数据库的连接
			conn = JDBCUtils.getConnection();
			// 2.预编译sql语句，返回PreparedStatement的实例
			ps = conn.prepareStatement(sql);
			// 3.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);// 小心参数声明错误！！
			}
			// 4.执行
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			//修改其为自动提交数据
			//主要针对于使用数据库连接池的使用
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// 5.资源的关闭
			JDBCUtils.closeResource(conn, ps);

		}
		return 0;

	}
}
