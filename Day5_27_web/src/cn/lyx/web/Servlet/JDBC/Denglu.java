package cn.lyx.web.Servlet.JDBC;

import java.sql.*;

public class Denglu {
    boolean login(String username, String password) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = Units.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql = "select * from log where username=? and passward=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
           preparedStatement.setString(2,password);
            ResultSet resultSet1 = preparedStatement.executeQuery();
            return resultSet1.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Units.close(resultSet, statement, connection);
        }
        return false;
    }
}
