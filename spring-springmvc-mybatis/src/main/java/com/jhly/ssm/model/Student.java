package com.jhly.ssm.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @Auther:JHLY
 * @Date:2019/9/30
 * @Description:com.jhly.ssm.model
 * @Version:1.0
 */
@Data
@Repository
public class Student {
    private Integer sid;
    private Integer age;
    private String sname;
    private Integer tid;
    private Teacher teacher;
}
