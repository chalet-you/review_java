package com.itheima._11插入Blob字段特殊情况说明;

import com.itheima._03JDBCUtils封装工具类数据库连接和关闭操作.JDBCUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

/*TODO
 * 如果在指定了相关的Blob类型以后，还报错：xxx too large，那么在mysql的安装目录下，
 * 找my.ini文件加上如下的配置参数： **max_allowed_packet=16M**。
 * 同时注意：修改了my.ini文件之后，需要重新启动mysql服务
 *
 *
 *
 */
public class InsertBlobDataNote {
    // 写入数据表中Blob类型数据
    @Test
    public void insertBlobData() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into test.customers(name,email,birth,photo)values(?,?,?,?)";

            ps = conn.prepareStatement(sql);

            ps.setObject(1,"李四");
            ps.setObject(2, "lisi@qq.com");
            ps.setObject(3,"1992-09-08");
//            InputStream is = new FileInputStream(new File("F:\\datas\\图片资源\\V2O.jpg"));
            InputStream is = new FileInputStream(new File("F:\\datas\\图片资源\\V2O.jpg"));
            ps.setBlob(4, is);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, ps);
        }

    }
}
