package cn.lyx.dao.userImpl;

import cn.lyx.dao.DaoUtils;
import cn.lyx.daomain.User;
import cn.lyx.daomain.admin;
import cn.lyx.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class imply implements DaoUtils {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        String str="select * from user";
        List<User> query = jdbcTemplate.query(str, new BeanPropertyRowMapper<User>(User.class));
        return query;
    }

    @Override
    public admin log(admin admin) {
        String str="select * from admin where username=? and password=?";
        cn.lyx.daomain.admin admin1 = null;
        try {
            admin1 = jdbcTemplate.queryForObject(str, new BeanPropertyRowMapper<admin>(admin.class),
                    admin.getUsername(), admin.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return admin1;
    }

    @Override
    public void add(User user) {
        String str="insert into user values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(str, null, user.getName(), user.getSex(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmile());
    }

    @Override
    public void updata(User user) {
        String str="UPDATE USER  SET NAME=? , sex=? , age=?, address=?,qq=?, emile=? WHERE id=?";
        jdbcTemplate.update(str,  user.getName(), user.getSex(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmile(),user.getId());
    }

    @Override
    public void delete(Integer id) {
        String str="delete from user where id=?";
        jdbcTemplate.update(str,id);
    }

    @Override
    public User getUser(Integer id) {
        String str="select * from user where id=?";
        User user = jdbcTemplate.queryForObject(str, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public List<User> fenYe(String id) {
        Integer a=Integer.valueOf(id);
        String str="select * from user limit (a-1)*5,5 ";
        List<User> query = jdbcTemplate.query(str, new BeanPropertyRowMapper<User>(User.class));
        return query;
    }
}
