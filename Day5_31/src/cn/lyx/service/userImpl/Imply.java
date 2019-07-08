package cn.lyx.service.userImpl;

import cn.lyx.dao.DaoUtils;
import cn.lyx.dao.userImpl.imply;
import cn.lyx.daomain.User;
import cn.lyx.daomain.admin;
import cn.lyx.service.UserService;

import java.util.List;

public class Imply implements UserService {
    private DaoUtils daoUtils=new imply();
    @Override
    public List<User> finAll() {
        return daoUtils.findAll();
    }

    @Override
    public admin logIn(admin admin) {
            return daoUtils.log(admin);
    }

    @Override
    public void add(User user) {
        daoUtils.add(user);
    }

    @Override
    public void update(User user) {
        daoUtils.updata(user);
    }

    @Override
    public void delete(Integer id) {
        daoUtils.delete(id);
    }

    @Override
    public User getUser(Integer id) {
       User user= daoUtils.getUser(id);
        return user;
    }

    @Override
    public List<User> fenYe(String id) {
        return daoUtils.fenYe(id);
    }
}
