package com.jhly.springbootdemo.mapper;

import com.jhly.springbootdemo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/10/1
 * @Description:com.jhly.springbootdemo.springboot01.mapper
 * @Version:1.0
 */
@Mapper
@Component
public interface UserMapper {

    @Select("select * from user")
    List<User> selAll();
}
