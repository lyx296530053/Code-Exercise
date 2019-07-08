package cn.lyx.jdbc;

import java.sql.*;

public class Test1 {
    public static void main(String[] args) throws SQLException {
        Connection root = DriverManager.getConnection("jdbc:mysql:///girls", "root", "2038118");
        String string = "select * from beauty where id=?";
        PreparedStatement preparedStatement = root.prepareStatement(string);
        preparedStatement.setInt(1,1);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int anInt = resultSet.getInt(1);
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            System.out.println(anInt+name+sex);
        }
    }
}
