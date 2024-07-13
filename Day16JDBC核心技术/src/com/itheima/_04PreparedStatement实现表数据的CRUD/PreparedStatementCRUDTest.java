package com.itheima._04PreparedStatement实现表数据的CRUD;

import com.itheima._03JDBCUtils封装工具类数据库连接和关闭操作.JDBCUtils;
import org.junit.Test;


import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class PreparedStatementCRUDTest {

    //查询customers表的一条记录
    @Test
    public void testQuery() throws Exception {
        // 1.获取连接
        Connection conn = JDBCUtils.getConnection();
        // 2.预编译sql语句，返回PreparedStatement的实例
        String sql = "select id,name,email,birth from test.customers where id =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        // 3.填充占位符
        ps.setObject(1, 1);
        // 4.执行并返回结果集
        ResultSet rs = ps.executeQuery();
        // 5.取出结果集中的数据
        while (rs.next()) {
            // 获取该条数据各个字段的值
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            Date birth = rs.getDate(4);
            // todo:  方式一：
            //System.out.println("id =" + id + ", name = " + name + ", email =" + email + ", birth =" + birth);
            //todo 方式二：将数据封装为一个对象（推荐）
            Customer customer = new Customer(id, name, email, birth);
            System.out.println(customer);
        }

    }

    //删除customers表的一条记录
    @Test
    public void testDelete() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.获取连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，返回PreparedStatement的实例
            String sql = "delete from test.customers where id =?";
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            ps.setObject(1, 5);
            // 4.执行
            /**
             * TODO
             *  ps.execute();
             *  如果执行的是查询操作，有返回结果，则此方法返回true；
             *  如果执行的是增、删、改操作，没有返回结果，则此方法返回false.
             *  ps.executeUpdate()
             *  返回受影响的行数
             */
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.关闭资源
            JDBCUtils.closeResource(conn, ps);

        }
    }

    //修改customers表的一条记录
    @Test
    public void testUpdate() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            ps.setObject(1, "莫扎特");
            ps.setObject(2, 18);
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn, ps);

        }
    }

    // 向customers表中添加一条记录
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
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
            conn = DriverManager.getConnection(url, user, password);

//		System.out.println(conn);

            //4.预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into test.customers(name,email,birth)values(?,?,?)";//?:占位符
            ps = conn.prepareStatement(sql);
            //5.填充占位符
            ps.setString(1, "哪吒");
            ps.setString(2, "nezha@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1000-01-01");
            ps.setDate(3, new Date(date.getTime()));

            //6.执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.资源的关闭

            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}
