package com.tony.service;

import com.tony.dao.IUserDao;
import com.tony.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.RecursiveTask;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserDao iUserDao;

    @Override
    public User getUserById(int id) {
        return iUserDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return iUserDao.getAllUsers();
    }
    @Override
    public List<User> getUsersByName(String name){return iUserDao.getUsersByName(name);}
    @Override
    public List<User> getUsersByRemark(String remark){return  iUserDao.getUsersByRemark(remark);}

    @Override
    public void updateUser(User user) {
        iUserDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        iUserDao.deleteUser(id);
    }

    @Override
    public void addUser(User user) {
        iUserDao.addUser(user);
    }
}
