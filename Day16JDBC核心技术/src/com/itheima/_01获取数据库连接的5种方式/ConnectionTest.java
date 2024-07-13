package com.itheima._01获取数据库连接的5种方式;

import org.junit.Test;

import java.io.InputStream;
import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.Properties;

public class ConnectionTest {
    @Test
    public void testConnection1() throws SQLException{
        // 获取Driver实现类对象
        /* todo：注意：com.mysql.jdbc.Driver 是 mysql-connector-java 5中的， 即如果你的数据库是5.x及以下的使用该驱动
                      com.mysql.cj.jdbc.Driver 是 mysql-connector-java 6中的，即如果你的数据库是6.0及以上版本的，使用该驱动
         */
        Driver driver = new com.mysql.cj.jdbc.Driver(); // todo：此处的 new com.mysql.cj.jdbc.Driver()出现第三方的api（既不是sun公司提供的，也不是我们自己写的，是第三方数据库厂商提供的）

        // url:http://localhost:8080/gmall/keyboard.jpg
        // jdbc:mysql:协议
        // localhost:ip地址
        // 3306：默认mysql的端口号
        // test:test数据库
        String url = "jdbc:mysql://192.168.88.100:3306/?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        Connection conn = driver.connect(url, info);

        System.out.println(conn);//com.mysql.cj.jdbc.ConnectionImpl@10bdf5e5
    }
    // 方式二：对方式一的迭代:在如下的程序中不出现第三方的api,使得程序具有更好的可移植性
    @Test
    public void testConnection2() throws Exception {
        // 1.获取Driver实现类对象：使用反射
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.提供要连接的数据库
        String url = "jdbc:mysql://192.168.88.100:3306/?useUnicode=true&characterEncoding=utf-8&useSSL=false";

        // 3.提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        // 4.获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);

    }

    // 方式三：使用DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception {
        // 1.获取Driver实现类的对象
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.提供另外三个连接的基本信息：
        String url = "jdbc:mysql://192.168.88.100:3306/?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user = "root";
        String password = "123456";

        // 注册驱动
        DriverManager.registerDriver(driver);

        // 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    // 方式四：可以只是加载驱动，不用显示的注册驱动过了。
    @Test
    public void testConnection4() throws Exception {
        // 1.提供三个连接的基本信息：
        String url = "jdbc:mysql://192.168.88.100:3306/?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user = "root";
        String password = "123456";

        // 2.加载Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //相较于方式三，可以省略如下的操作：
//		Driver driver = (Driver) clazz.newInstance();
//		// 注册驱动
//		DriverManager.registerDriver(driver);
        //为什么可以省略上述操作呢？
		/*
		 * 在mysql的Driver实现类中，声明了如下的操作：
		 * static {
				try {
					java.sql.DriverManager.registerDriver(new Driver());
				} catch (SQLException E) {
					throw new RuntimeException("Can't register driver!");
				}
			}
		 */

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
    //方式五(final版)：将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
    /*
     * 此种方式的好处？
     * 1.实现了数据与代码的分离。实现了解耦
     * 2.如果需要修改配置文件信息，可以避免程序重新打包。
     */
    @Test
    public void getConnection5() throws Exception{

        //1.读取配置文件中的4个基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }
}
