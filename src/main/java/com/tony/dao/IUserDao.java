package com.tony.dao;

import com.tony.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IUserDao {

    User getUserById(int id);

    List<User> getAllUsers();

    List<User> getUsersByName(String name);

    List<User> getUsersByRemark(String remark);

    void updateUser(User user);

    void deleteUser(int id);

    void addUser(User user);
}
