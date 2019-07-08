package cn.lyx.se.everday.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Test2 {
    public static void main(String[] args) throws Exception {
//        Properties properties=new Properties();
////        InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("druid.properties");
////        properties.load(systemResourceAsStream);
////        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
////        dataSource.getConnection();
        Connection connection = Utiles.getConnection();
        String sql="insert into boys values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"李白");
        preparedStatement.setString(2,"2000");
        preparedStatement.executeUpdate();
    }
}
