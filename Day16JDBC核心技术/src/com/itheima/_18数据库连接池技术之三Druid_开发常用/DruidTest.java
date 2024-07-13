package com.itheima._18数据库连接池技术之三Druid_开发常用;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidTest {

	//方式一：不推荐
	@Test
	public void getConection() throws Exception{
		//创建了Druid的数据库连接池
		DruidDataSource source = new DruidDataSource();

		//设置基本信息
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://192.168.88.100:3306/?useUnicode=true&characterEncoding=utf-8&useSSL=false&rewriteBatchedStatements=true");
		source.setUsername("root");
		source.setPassword("123456");
		//还可以设置其他涉及数据库连接池管理的相关属性：
		source.setInitialSize(10);
		source.setMaxActive(10);
		Connection conn = source.getConnection();
		System.out.println(conn); // com.mysql.cj.jdbc.ConnectionImpl@6121c9d6

	}

	//方式二：推荐：使用配置文件
	@Test
	public void getConnection1() throws Exception{
		Properties pros = new Properties();
		// 使用系统类加载器指向配置文件生成输入流
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
		// 加载配置文件到属性对象中
		pros.load(is);
		// 创建BDCP数据库线程池
		DataSource source = DruidDataSourceFactory.createDataSource(pros);
		Connection conn = source.getConnection();
		System.out.println(conn); // com.mysql.cj.jdbc.ConnectionImpl@eafc191
		
	}
}
