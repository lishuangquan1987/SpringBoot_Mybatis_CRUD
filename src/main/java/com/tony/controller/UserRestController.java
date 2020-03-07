package com.tony.controller;

import com.tony.entities.User;
import com.tony.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userRest")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/hello")
    public String hello()
    {
        return "hello,world";
    }

    @RequestMapping("/userTest")
    public User userTest()
    {
        return new User();
    }

    @RequestMapping("/showAllUsers")
    public List<User> showAllUsers()
    {
        return userService.getAllUsers();
    }
}
