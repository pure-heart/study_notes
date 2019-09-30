package com.jhly.ssm.controller;

import com.jhly.ssm.model.Student;
import com.jhly.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/30
 * @Description:com.jhly.ssm.controller
 * @Version:1.0
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("all")
    public List<Student> getStudents(){
        System.out.println(studentService.selectAllStudent());
            return studentService.selectAllStudent();
    }
}
