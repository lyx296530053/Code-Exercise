package JDBC;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees", "root", "2038118");
            System.out.println(conn);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM employees WHERE department_id<90 OR department_id>110 ";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getObject(1) + "\t" + rs.getObject(2) +
                        "\t" + rs.getObject(3) + "\t" + rs.getObject(4) + "\t" + rs.getObject(5));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
