package com.jhly.ssm.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/30
 * @Description:com.jhly.ssm.model
 * @Version:1.0
 */
@Data
@Repository
public class Teacher {
    private Integer id;
    private String tname;
    private List<Student> studentList;
}
