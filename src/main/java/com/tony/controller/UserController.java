package com.tony.controller;

import com.tony.entities.User;
import com.tony.service.IUserService;
import com.tony.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;
    @RequestMapping("/main")
    public String main(Model model)
    {
        List<User> list=userService.getAllUsers();
        model.addAttribute("users",list);
        return "main";
    }

    @RequestMapping("/searchUser")
    @ResponseBody
    public List<User> searchUser(String filterStr)
    {
        System.out.println("searchUser=>filterStr:"+filterStr);
        List<User> users=new ArrayList<User>();
        if (StringUtils.isEmpty(filterStr))
        {
           List<User> users1=userService.getAllUsers();
           users.addAll(users1);
        }
        else
        {
            List<User> users1=userService.getUsersByName(filterStr);
            users.addAll(users1);
            System.out.println("searchUser=>users1:"+users1);
            List<User> users2= userService.getUsersByRemark(filterStr);
            System.out.println("searchUser=>users2:"+users2);
            for (User user:users2)
            {
                boolean isExist=false;
                for (User u : users)
                {
                    if (u.getId()==user.getId())
                    {
                        isExist=true;
                    }
                }
                if (!isExist)
                {
                    users.add(user);
                }
            }
        }
        return users;
    }
    @RequestMapping("/gotoModifyPage")
    public String gotoModifyPage(int id, Model model)
    {
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "modify";
    }
    @RequestMapping("/acceptModify")
    @ResponseBody
    public String acceptModify(User user)
    {
        System.out.println("AcceptModify=>"+user);
        userService.updateUser(user);
        return "ok";
    }
    @RequestMapping("/jumpToAddUser")
    public String jumpToAddUser()
    {
        return "addUser";
    }

    @RequestMapping("/acceptAdd")
    @ResponseBody
    public String acceptAdd(User user)
    {
        System.out.println("acceptAdd=>"+user);
        userService.addUser(user);
        return "ok";
    }


}
