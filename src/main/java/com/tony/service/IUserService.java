package com.tony.service;

import com.tony.entities.User;

import java.util.List;

public interface IUserService {
    User getUserById(int id);

    List<User> getAllUsers();

    List<User> getUsersByName(String name);

    List<User> getUsersByRemark(String remark);

    void updateUser(User user);

    void deleteUser(int id);

    void addUser(User user);
}
