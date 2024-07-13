package com.itheima._16数据库连接池技术之一C3P0_不常用;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Test {
	//方式一：不推荐
	@Test
	public void getConnection() throws Exception{
		//获取c3p0数据库连接池
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "com.mysql.cj.jdbc.Driver" );
		cpds.setJdbcUrl( "jdbc:mysql://192.168.88.100:3306/?useUnicode=true&characterEncoding=utf-8&useSSL=false&rewriteBatchedStatements=true" );
		cpds.setUser("root");                                  
		cpds.setPassword("123456");
		//通过设置相关的参数，对数据库连接池进行管理：
		//设置初始时数据库连接池中的连接数
		cpds.setInitialPoolSize(10);
		
		Connection conn = cpds.getConnection();
		System.out.println(conn);//com.mchange.v2.c3p0.impl.NewProxyConnection@3796751b
		
		//销毁c3p0数据库连接池
//		DataSources.destroy( cpds );
	}
	//方式二：使用配置文件
	@Test
	public void getConnection1() throws SQLException{
		ComboPooledDataSource cpds = new ComboPooledDataSource("myc3p0");
		Connection conn = cpds.getConnection();
		System.out.println(conn);//com.mchange.v2.c3p0.impl.NewProxyConnection@2f7a2457
	}
}
