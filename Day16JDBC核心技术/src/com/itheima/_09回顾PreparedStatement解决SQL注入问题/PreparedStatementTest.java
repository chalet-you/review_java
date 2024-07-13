package com.itheima._09回顾PreparedStatement解决SQL注入问题;

import com.itheima._03JDBCUtils封装工具类数据库连接和关闭操作.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 *TODO
 * @Description 演示使用PreparedStatement替换Statement，解决SQL注入问题
 * @author
 * @version
 * @date 上午11:52:37
 *TODO
 * 除了解决Statement的拼串、sql问题之外，PreparedStatement还有哪些好处呢？
 * 1.PreparedStatement操作Blob的数据，而Statement做不到。
 * 2.PreparedStatement可以实现更高效的批量操作。
 *
 */
public class PreparedStatementTest {

    public static void main(String[] args) {
        testLogin();
    }


    public static void testLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入用户名："); // 1' or
        String user = scanner.nextLine();
        System.out.print("请输入密码：");   // =1 OR '1' = '1
        String password = scanner.nextLine();
        //SELECT user,password FROM user_table WHERE user = '1' or ' AND password = '=1 or '1' = '1'
        String sql = "SELECT user,password FROM test.user_table WHERE user = ? AND password = ?";
        User returnUser = getOneInstance(User.class,sql,user,password);
        if(returnUser != null){
            System.out.println("登录成功");
        }else{
            System.out.println("用户名不存在或密码错误");
        }
    }

    // TODO 针对于不同的表的通用的查询操作，返回表中的一条记录
    public static <T> T getOneInstance(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            //执行，获取结果集
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取每个列的列值:通过ResultSet
                    Object columnValue = rs.getObject(i + 1);
                    //通过ResultSetMetaData
                    //获取列的列名：getColumnName() --不推荐使用
                    //获取列的别名：getColumnLabel()
//					String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //通过反射，将对象指定名columnName的属性赋值为指定的值columnValue
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }

                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
}
