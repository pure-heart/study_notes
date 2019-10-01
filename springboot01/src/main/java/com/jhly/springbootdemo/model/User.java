package com.jhly.springbootdemo.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @Auther:JHLY
 * @Date:2019/10/1
 * @Description:com.jhly.springbootdemo.springboot01.model
 * @Version:1.0
 */
@Repository
@Data
public class User {
    private String uname;
    private String upass;
    private Integer age;
    private  String remark;
    private Date createDate;
}
