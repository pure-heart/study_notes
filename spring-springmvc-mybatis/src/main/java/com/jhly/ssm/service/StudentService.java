package com.jhly.ssm.service;

import com.jhly.ssm.model.Student;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/30
 * @Description:com.jhly.ssm.service
 * @Version:1.0
 */
public interface StudentService {
    public List<Student> selectAllStudent();
}
