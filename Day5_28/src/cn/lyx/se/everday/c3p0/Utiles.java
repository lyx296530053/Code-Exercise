package cn.lyx.se.everday.c3p0;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Utiles {
    private static DataSource dataSources;

    static {
        try {
            Properties properties = new Properties();
            InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("druid.properties");
            properties.load(systemResourceAsStream);
            dataSources = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSources.getConnection();
    }

    public static void close(ResultSet set, Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Statement statement, Connection connection) {
        close(null, statement, connection);
    }
    public  static DataSource getDataSources(){
        return dataSources;
    }
}
