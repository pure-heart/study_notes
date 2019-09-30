package com.jhly.ssm.service.impl;

import com.jhly.ssm.mapper.StudentMapper;
import com.jhly.ssm.model.Student;
import com.jhly.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/30
 * @Description:com.jhly.ssm.service.impl
 * @Version:1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> selectAllStudent() {
        return studentMapper.selectAll();
    }
}
