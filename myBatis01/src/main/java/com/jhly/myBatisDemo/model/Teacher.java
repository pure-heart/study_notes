package com.jhly.myBatisDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/26
 * @Description:com.jhly.myBatisDemo.model
 * @Version:1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private Integer id;
    private String tname;
    private List<Student> list;
}
