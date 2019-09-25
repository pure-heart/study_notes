package com.jhly.myBatisDemo.model;

import lombok.Data;

import java.util.Date;

/**
 * @Auther:JHLY
 * @Date:2019/9/25
 * @Description:com.jhly.myBatisDemo.model
 * @Version:1.0
 */
@Data
public class User {
    private Integer id;
    private String uname;
    private String upass;
    private Integer age;
    private String remark;
    private Date createDate;
}
