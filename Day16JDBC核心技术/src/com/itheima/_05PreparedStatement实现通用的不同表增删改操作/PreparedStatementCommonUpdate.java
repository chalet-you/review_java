package com.itheima._05PreparedStatement实现通用的不同表增删改操作;

import com.itheima._03JDBCUtils封装工具类数据库连接和关闭操作.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 实现不同表的通用的增删改操作
 */
public class PreparedStatementCommonUpdate {


    @Test
    public void testCommonUpdate() {
//        String sql = "delete from test.customers where id = ?";
//        update(sql, 8);
        String sql = "update test.`order` set order_name = ? where order_id = ?";
        int updateCount = update(sql,"BB","2");
        if(updateCount > 0){
            System.out.println("添加成功");

        }else{
            System.out.println("添加失败");
        }
    }

    public int update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            /**
             * TODO
             *  ps.execute();
             *  如果执行的是查询操作，有返回结果，则此方法返回true；
             *  如果执行的是增、删、改操作，没有返回结果，则此方法返回false.
             *  ps.executeUpdate()
             *  返回受影响的行数，如果为 0 表示没有行数受到影响
             */
            //4.执行
           return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
        return 0;
    }
}
