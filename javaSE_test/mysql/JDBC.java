package mysql;
/**
 * @author Komorebi
 * @since 2021.12.22.11:07
 */
import java.sql.*;
import java.util.*;
public class JDBC {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        Scanner sc = new Scanner(System.in);

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&&useSSL=true";
        String username = "root";
        String password = "10086";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("数据库连接成功！");

            System.out.println("请输入要查询人的姓名：");
            String name = sc.next();
            String sql = "select * from student where stu_name=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,name);
            rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("name:"+rs.getString(1)+'\t' +
                        "age:"+rs.getInt(2));
            }

            name = sc.next();
            int age = sc.nextInt();
            sql = "insert into student values(?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,name);
            pst.setInt(2,age);
            pst.executeUpdate();

            sql = "select * from student";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("name:"+rs.getString(1)+'\t' +
                        "age:"+rs.getInt(2));
            }

            name = sc.next();
            age = sc.nextInt();
            sql = "update student set stu_name=? where stu_age=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,name);
            pst.setInt(2,age);
            pst.executeUpdate();

            name = sc.next();
            sql ="delete from student where stu_name=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,name);
            pst.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                conn.close();
                sc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
