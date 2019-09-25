package com.jhly.hibernateDemo.model;


import lombok.Data;

import java.util.Date;

/**
 * @Auther:JHLY
 * @Date:2019/9/23
 * @Description:com.jhly.hibernateDemo.model
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
