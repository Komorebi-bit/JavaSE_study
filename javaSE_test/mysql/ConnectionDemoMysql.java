package mysql;

import java.sql.*;

/**
 * @author Komorebi
 * @since 2021.12.01.16:59
 */
public class ConnectionDemoMysql {
    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Savepoint s = null;
        try {
            //加载JDBC驱动程序
            String DriverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(DriverName);
            //连接数据库
            String url = "jdbc:mysql://localhost:3306/admin?useUnicode=true&characterEncoding=UTF-8&&useSSL=true";
            String user = "root";
            String password = "10086";
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接成功！");
            //创建statement对象
            statement = connection.createStatement();
            //执行sql语句
            System.out.println("遍历数据库");
            resultSet = statement.executeQuery("select * from student");
            //遍历student
            while(resultSet.next()){
                System.out.println(resultSet.getString("sno")+'\t'+
                        resultSet.getString("sname")+'\t'+
                        resultSet.getInt("sage")+'\t'+
                        resultSet.getString("ssex"));
            }
            System.out.println("---------------------------------------------");

            int count=0;

            boolean bool = connection.getAutoCommit();
            //获取当前事务提交状态
            connection.setAutoCommit(false);
            //关闭自动提交

            s = connection.setSavepoint();
            //设置保存点

            //count = statement.executeUpdate("update student set sage=99 where sno='D0004'");

            //插入操作
            System.out.println("插入");
            count = statement.executeUpdate("insert into student values ('D0006','曹操',62,'男')");
            resultSet = statement.executeQuery("select * from student");
            while(resultSet.next()){
                System.out.println(resultSet.getString("sno")+'\t'+
                        resultSet.getString("sname")+'\t'+
                        resultSet.getInt("sage")+'\t'+
                        resultSet.getString("ssex"));
            }
            System.out.println("---------------------------------------------");

            //删除操作
            System.out.println("删除");
            count = statement.executeUpdate("delete from student where sname='曹操'");

            //提交事务
            connection.commit();
            //恢复原有事务状态
            connection.setAutoCommit(bool);

            resultSet = statement.executeQuery("select * from student");
            while(resultSet.next()){
                System.out.println(resultSet.getString("sno")+'\t'+
                        resultSet.getString("sname")+'\t'+
                        resultSet.getInt("sage")+'\t'+
                        resultSet.getString("ssex"));
            }
            System.out.println("---------------------------------------------");

            //更新操作
            System.out.println("更新貂蝉的年龄");
            count = statement.executeUpdate("update student set sage=0 where sno='D0004'");
            resultSet = statement.executeQuery("select * from student");
            while(resultSet.next()){
                System.out.println(resultSet.getString("sno")+'\t'+
                        resultSet.getString("sname")+'\t'+
                        resultSet.getInt("sage")+'\t'+
                        resultSet.getString("ssex"));
            }
            System.out.println("---------------------------------------------");

            //DatabaseMetaData databaseMetaData = connection.getMetaData();
            //System.out.println(databaseMetaData.getURL());
            //System.out.println(databaseMetaData.getUserName());
            //System.out.println(databaseMetaData.getDriverName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            if(connection!=null){
                try {
                    //出现异常，回滚
                    connection.rollback(s);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally{
            try {
                //按顺序关闭连接
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
