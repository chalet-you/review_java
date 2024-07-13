package com.itheima._06针对customers表实现通用的查询操作;

import com.itheima._03JDBCUtils封装工具类数据库连接和关闭操作.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author shkstart  Email:shkstart@126.com
 * @Description 针对于Customers表实现通用的查询操作
 * @date 上午10:04:55
 */
public class CustomerForQuery {
    @Test
    public void testQueryForCustomers() {
        String sql = "select id,name,birth,email from test.customers where id = ?";
        Customer customer = queryForCustomers(sql, 13);
        System.out.println(customer);

        sql = "select name,email from test.customers where name = ?";
        Customer customer1 = queryForCustomers(sql, "周杰伦");
        System.out.println(customer1);
    }

    /**
     * @throws Exception
     * @Description 针对于customers表的通用的查询操作
     * @author shkstart
     * @date 上午10:23:40
     */
    public Customer queryForCustomers(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            //获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                Customer cust = new Customer();
                //处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columValue = rs.getObject(i + 1);

                    //获取每个列的列名
//					String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给cust对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = Customer.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(cust, columValue);
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);

        }

        return null;
    }
}
