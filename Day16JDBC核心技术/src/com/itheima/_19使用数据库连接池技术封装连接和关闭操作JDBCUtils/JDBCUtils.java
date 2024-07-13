package com.itheima._19使用数据库连接池技术封装连接和关闭操作JDBCUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @Description 使用数据库连接池技术封装操作数据库的工具类
 * @author youxuan Email:youxuan@126.com
 * @version
 * @date 上午9:10:02
 *
 */
public class JDBCUtils {

    /**
     *
     * TODO: 使用C3P0的数据库连接池技术
     */
    //TODO: 数据库连接池只需提供一个即可。
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("myc3p0");
    public static Connection getConnection1() throws SQLException{
        Connection conn = cpds.getConnection();

        return conn;
    }

    /**
     *
     * TODO: 使用DBCP数据库连接池技术获取数据库连接
     */
    //TODO: 创建一个DBCP数据库连接池
    private static DataSource source;
    static{
        try {
            Properties pros = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
            pros.load(is);
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection2() throws Exception{

        Connection conn = source.getConnection();

        return conn;
    }

    /**
     * TODO: 使用Druid数据库连接池技术
     */
    private static DataSource source1;
    static{
        try {
            Properties pros = new Properties();

            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");

            pros.load(is);

            source1 = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection3() throws SQLException{

        Connection conn = source1.getConnection();
        return conn;
    }





    /**
     *
     * @Description 获取数据库的连接
     * @author youxuan
     * @date 上午9:11:23
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        // 1.读取配置文件中的4个基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        // 2.加载驱动
        Class.forName(driverClass);

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    /**
     *
     * @Description 关闭连接和Statement的操作
     * @author youxuan
     * @date 上午9:12:40
     * @param conn
     * @param ps
     */
    public static void closeResource(Connection conn,Statement ps){
        try {
            if(ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @Description 关闭资源操作
     * @author youxuan
     * @date 上午10:21:15
     * @param conn
     * @param ps
     * @param rs
     */
    public static void closeResource(Connection conn,Statement ps,ResultSet rs){
        try {
            if(ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
