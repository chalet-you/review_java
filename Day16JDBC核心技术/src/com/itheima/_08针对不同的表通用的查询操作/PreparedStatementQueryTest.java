package com.itheima._08针对不同的表通用的查询操作;

import com.itheima._03JDBCUtils封装工具类数据库连接和关闭操作.JDBCUtils;
import com.itheima._07针对order表实现通用的查询操作.Order;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author shkstart Email:shkstart@126.com
 * @Description 使用PreparedStatement实现针对于不同表的通用的查询操作
 * @date 上午11:32:55
 */
public class PreparedStatementQueryTest {

    @Test
    public void testGetMultipleInstance() {
        String sql = "select id,name,birth,email from test.customers where id < ?";
        List<Customer> customerLists = getMultipleInstance(Customer.class, sql, 6);
        customerLists.forEach(System.out::println);
        sql = "select order_id orderId,order_name orderName from test.`order` where order_id < ?";
        List<Order> orderLists = getMultipleInstance(Order.class, sql, 6);
        orderLists.forEach(System.out::println);
    }

    // TODO 针对于不同的表的通用的查询操作，返回表中的多条记录
    public <T> List<T> getMultipleInstance(Class<T> clazz, String sql, Object... args) {
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
            List<T> lists = new ArrayList<>();
            while (rs.next()) {
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
                lists.add(t);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    @Test
    public void testGetOneInstance() {
        String sql = "select id,name,birth,email from test.customers where id = ?";
        Customer customer = getOneInstance(Customer.class, sql, 6);
        System.out.println(customer);
        sql = "select order_id orderId,order_name orderName from test.`order` where order_id = ?";
        Order order = getOneInstance(Order.class, sql, 1);
        System.out.println(order);
    }

    // TODO 针对于不同的表的通用的查询操作，返回表中的一条记录
    public <T> T getOneInstance(Class<T> clazz, String sql, Object... args) {
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
