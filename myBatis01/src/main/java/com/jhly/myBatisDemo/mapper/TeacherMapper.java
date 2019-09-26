package com.jhly.myBatisDemo.mapper;

import com.jhly.myBatisDemo.model.Teacher;

/**
 * @Auther:JHLY
 * @Date:2019/9/26
 * @Description:com.jhly.myBatisDemo.mapper
 * @Version:1.0
 */
public interface TeacherMapper {

    Teacher selectById(int id);
}
