package cn.lyx.JDBC;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class LogIn {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    public User log(User loginUser) {
        try {
            String sql = "select * from log where username = ? and passward = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
