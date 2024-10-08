package com.itheima._10读取或写入数据表中Blob类型数据;

import com.itheima._03JDBCUtils封装工具类数据库连接和关闭操作.JDBCUtils;
import com.itheima._08针对不同的表通用的查询操作.Customer;
import org.junit.Test;

import java.io.*;
import java.sql.*;
/**
 *
 * @Description 测试使用PreparedStatement操作Blob类型的数据
 * @author shkstart  Email:shkstart@126.com
 * @version
 * @date 下午4:08:58
 *
 */
public class QueryAndInsertBlobDataTest {

    // 写入数据表中Blob类型数据
    @Test
    public void insertBlobData() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into test.customers(name,email,birth,photo)values(?,?,?,?)";

            ps = conn.prepareStatement(sql);

            ps.setObject(1,"袁浩");
            ps.setObject(2, "yuan@qq.com");
            ps.setObject(3,"1992-09-08");
            InputStream is = new FileInputStream(new File("F:\\datas\\图片资源\\meimei.jpg"));
            ps.setBlob(4, is);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        JDBCUtils.closeResource(conn, ps);
        }

    }

    // 读取数据表中Blob类型数据
    @Test
    public void queryBlobData() {
        Connection conn = null;
        PreparedStatement ps = null;
        InputStream is = null;
        OutputStream fos = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth,photo from test.customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 21);
            rs = ps.executeQuery();
            if(rs.next()){
                //			方式一：
                //			int id = rs.getInt(1);
                //			String name = rs.getString(2);
                //			String email = rs.getString(3);
                //			Date birth = rs.getDate(4);
                //方式二：
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");

                Customer cust = new Customer(id, name, email, birth);
                System.out.println(cust);

                //将Blob类型的字段下载下来，以文件的方式保存在本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("meinv.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while((len = is.read(buffer)) != -1){
                    fos.write(buffer, 0, len);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            try {
                if(is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JDBCUtils.closeResource(conn, ps, rs);
        }
    }
}
