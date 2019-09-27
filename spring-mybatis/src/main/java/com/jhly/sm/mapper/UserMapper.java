package com.jhly.sm.mapper;

import com.jhly.sm.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.sm.mapper
 * @Version:1.0
 */
public interface UserMapper {
    @Select("select * from user")
    List<User> selectAll();
}
