package com.jhly.myBatisDemo.model;

import lombok.Data;

/**
 * @Auther:JHLY
 * @Date:2019/9/26
 * @Description:com.jhly.myBatisDemo.model
 * @Version:1.0
 */
@Data
public class Student {
    private Integer sid;
    private Integer age;
    private String sname;
    private Integer tid;
    private Teacher teacher;
}
