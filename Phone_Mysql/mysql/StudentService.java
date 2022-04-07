package mysql;

import entity.Student;

import java.sql.*;

/**
 * @author Komorebi
 * @since 2021.12.16.15:03
 */
public class StudentService {
    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/admin?useUnicode=true&characterEncoding=UTF-8&&useSSL=true";
    String useName = "root";
    String password = "10086";
    /*
    * 数据库连接
    */
    public void DBConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, useName, password);
            System.out.println("数据库连接成功！");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动连接失败");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
    }
    /*
    * 展示内容
    */
    public void show(){
        String sql = "select * from student";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("学号\t\t姓名\t年龄\t性别\t状态\t\t成绩\t专业");
            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+'\t'+
                        resultSet.getString(2)+'\t'+
                        resultSet.getInt(3)+'\t'+
                        resultSet.getString(4)+'\t'+
                        resultSet.getString(5)+'\t'+
                        resultSet.getInt(6)+'\t'+
                        resultSet.getString(7)+'\t');
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
    * 查询
    * 根据参数num,查询数据库中是否有该记录
    * 有则返回true，否则返回false
    */
    public boolean query(String num){
        String sql = "select * from student where sno=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,num);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    /*
    * 添加
    * 向数据库中添加记录student
    * 添加成功返回true,否则返回false
    */
    public boolean add(Student student){
        String sql = "insert into student values(?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getNum());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setString(4,student.getGender());
            preparedStatement.setString(5,student.getStatus());
            preparedStatement.setInt(6,student.getScore());
            preparedStatement.setString(7,student.getProfession());
            int count = preparedStatement.executeUpdate();
            if(count>0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /*
    * 删除
    * 删除数据库中sno为num的记录
    * 删除成功返回true，否则false
    */
    public boolean delete(String num){
        String sql = "delete from student where sno=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,num);
            int count = preparedStatement.executeUpdate();
            if(count>0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /*
    * 上锁
    * 找到数据库中sno为num的且sstatus为normal的记录，上锁
    * 成功上锁返回true，否则返回false
    */
    public boolean locked(String num){
        String sql = "update student set sstatus='locked' where sno=?and sstatus = 'normal'";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,num);
            int count = preparedStatement.executeUpdate();
            if(count>0)
                return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    /*
    * 解锁
    * 找到数据库中sno为num的且sstatus为locked的记录，解锁
    * 找到并成功解锁返回true，否则返回false
    */
    public boolean unlock(String num){
        String sql = "update student set sstatus='normal' where sno=?and sstatus = 'locked'";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,num);
            int count = preparedStatement.executeUpdate();
            if(count>0)
                return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    /*
    * 关闭数据库连接，释放所有资源
    */
    public void closeAll(){
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
