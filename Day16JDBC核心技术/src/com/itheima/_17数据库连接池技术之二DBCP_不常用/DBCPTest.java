package com.itheima._17数据库连接池技术之二DBCP_不常用;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class DBCPTest {
	/**
	 * 
	 * @Description 测试DBCP的数据库连接池技术
	 * @author shkstart
	 * @throws SQLException 
	 * @date 下午3:20:50
	 */
	//方式一：不推荐
	@Test
	public void getConnection() throws SQLException{
		//创建了DBCP的数据库连接池
		BasicDataSource source = new BasicDataSource();
		
		//设置基本信息
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=utf-8&useSSL=false&rewriteBatchedStatements=true&serverTimezone=UTC");
//		source.setUrl("jdbc:mysql://localhost:3306/?serverTimezone=UTC");
		source.setUsername("root");
		source.setPassword("123456");
		
		//还可以设置其他涉及数据库连接池管理的相关属性：
		source.setInitialSize(10);
		source.setMaxActive(10);
		//。。。
		
		Connection conn = source.getConnection();
		System.out.println(conn);// jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=utf-8&useSSL=false&rewriteBatchedStatements=true&serverTimezone=UTC, UserName=root@localhost, MySQL Connector/J
	}
	
	//方式二：推荐：使用配置文件
	@Test
	public void getConnection1() throws Exception{
		Properties pros = new Properties();
		
		//方式1：
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
		//方式2：
		//FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
		
		
		pros.load(is);
		// 创建BDCP数据库线程池
		DataSource source = BasicDataSourceFactory.createDataSource(pros);
		
		Connection conn = source.getConnection();
		System.out.println(conn);//jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=utf-8&useSSL=false&rewriteBatchedStatements=true&serverTimezone=UTC, UserName=root@localhost, MySQL Connector/J
	}

	public static void main(String[] args) {
		DataSource dataSource = null;
	}
	
}
