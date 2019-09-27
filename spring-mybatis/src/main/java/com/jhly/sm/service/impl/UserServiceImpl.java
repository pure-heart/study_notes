package com.jhly.sm.service.impl;

import com.jhly.sm.mapper.UserMapper;
import com.jhly.sm.model.User;
import com.jhly.sm.service.UserService;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.sm.service.impl
 * @Version:1.0
 */
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> show() {
        return userMapper.selectAll();
    }
}
