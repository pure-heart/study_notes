package com.jhly.springbootdemo.service;

import com.jhly.springbootdemo.mapper.UserMapper;
import com.jhly.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/10/1
 * @Description:com.jhly.springbootdemo.service
 * @Version:1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers(){
        return userMapper.selAll();
    }
}
