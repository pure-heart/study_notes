package com.jhly.myBatisDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Auther:JHLY
 * @Date:2019/9/25
 * @Description:com.jhly.myBatisDemo.model
 * @Version:1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String uname;
    private String upass;
    private Integer age;
    private String remark;
    private Date createDate;
}
