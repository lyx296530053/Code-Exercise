package cn.lyx.web.xml.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = Units.getConnection();
            connection.setAutoCommit(false);
            String a = "update log set passward=passward-? where id=?";
            String b = "update log set passward=passward+? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(a);
            PreparedStatement preparedStatement1 = connection.prepareStatement(b);
            preparedStatement.setInt(1, 500);
            preparedStatement.setInt(2, 1);
            preparedStatement1.setInt(1, 500);
            preparedStatement1.setInt(2, 2);
            preparedStatement.executeUpdate();
            int c = 3 / 0;
            preparedStatement1.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}