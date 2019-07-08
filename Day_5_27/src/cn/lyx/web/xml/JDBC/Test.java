package cn.lyx.web.xml.JDBC;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/girls", "root", "2038118");
            Statement statement = connection.createStatement();
            String request = "select * from boys";
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                int anInt = resultSet.getInt("id");
                String name = resultSet.getString("boyname");
                int anInt1 = resultSet.getInt("usercp");
                System.out.println(anInt + "  " + name + "  " + anInt1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
