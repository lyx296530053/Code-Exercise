package cn.lyx.dao;

import cn.lyx.daomain.User;
import cn.lyx.daomain.admin;

import java.util.List;

public interface DaoUtils {
    List<User> findAll();
    admin log(admin admin);
    void add (User user);
    void updata(User user);
    void delete(Integer id);
    User getUser(Integer id);
    List<User> fenYe(String id);
}
