package com.jhly.springbootdemo.controller;

import com.jhly.springbootdemo.service.UserService;
import com.jhly.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/10/1
 * @Description:com.jhly.springbootdemo.springboot01.controller
 * @Version:1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public List<User> getAll(){

        return userService.getUsers();
    }
}
