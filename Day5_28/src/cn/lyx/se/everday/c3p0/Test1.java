package cn.lyx.se.everday.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        for (int i=0;i<10;i++) {
            Connection connection = comboPooledDataSource.getConnection();
            System.out.println(connection);
        }
    }
}
