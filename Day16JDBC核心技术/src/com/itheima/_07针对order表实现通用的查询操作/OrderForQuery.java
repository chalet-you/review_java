package com.itheima._07针对order表实现通用的查询操作;

import com.itheima._03JDBCUtils封装工具类数据库连接和关闭操作.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class OrderForQuery {

    /*TODO
     * 针对于表的字段名与类的属性名不相同的情况：
     * 1. 必须声明sql时，使用类的属性名来命名字段的别名
     * 2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),
     *    获取列的别名。为了是解决类的字段名和表的字段名不一致问题
     *  说明：如果sql中没有给字段其别名，getColumnLabel()获取的就是列名
     *
     *
     */
    @Test
    public void testOrderForQuery() {
        String sql = "select order_id as orderId,order_name as orderName,order_date as orderDate from test.`order` where order_id = ?";
        Order order = queryForOrder(sql, 1);
        System.out.println(order);
    }


    public Order queryForOrder(String sql, Object... args) {
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
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {
                    //获取每个列的列值:通过ResultSet
                    Object columnValue = rs.getObject(i + 1);
                    //通过ResultSetMetaData
                    //获取列的列名：getColumnName() --不推荐使用
                    //获取列的别名：getColumnLabel()
//					String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //通过反射，将对象指定名columnName的属性赋值为指定的值columnValue
                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order, columnValue);
                }

                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.closeResource(conn, ps, rs);
        }


        return null;

    }
}
