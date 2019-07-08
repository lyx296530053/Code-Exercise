package cn.lyx.service;

import cn.lyx.daomain.User;
import cn.lyx.daomain.admin;

import java.util.List;

public interface UserService {
    public List<User> finAll();
    public admin logIn(admin admin);
    public void add(User user);
    void update(User user);
    void delete(Integer id);
    User getUser(Integer id);
    List<User> fenYe(String id);
}
