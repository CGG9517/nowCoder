package interveiw.database;

import java.io.*;
import java.sql.*;

/**
 * @Class: JDBCTest
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/3
 */
public class JDBCTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "19941224");

            PreparedStatement ps = conn.prepareStatement("insert into photos (name, photo)  values (?, ?)");
            ps.setString(1, "Jiangchao");
            try (FileInputStream in = new FileInputStream("C:\\Users\\Jiang Chao\\Desktop\\实习\\江超.jpg")){
                ps.setBinaryStream(2, in);
                System.out.println(ps.executeUpdate() == 1 ? "插入成功" : "插入失败");

            } catch (IOException e) {
                System.out.println("读取照片失败!");
            }

            // 读取照片
            ps = conn.prepareStatement("select photo from photos where id = 1");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next())
                try (InputStream in = resultSet.getBinaryStream(1);
                     OutputStream out = new FileOutputStream("C:\\Users\\Jiang Chao\\Desktop\\实习\\江超2.jpg")) {
                    byte[] buffer = new byte[4096];
                    int byteToRead;
                    while ((byteToRead = in.read(buffer)) != -1){
                        out.write(buffer, 0, byteToRead);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }





        } catch (ClassNotFoundException | SQLException  e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed())
                {
                    conn.close();
                    conn = null; // 指示垃圾回收器可以回收该对象
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
