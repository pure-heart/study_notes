package com.jhly.springbootdemo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

/**
 * @Auther:JHLY
 * @Date:2019/10/1
 * @Description:com.jhly.springbootdemo.springboot01.entity
 * @Version:1.0
 */
@Data
@Repository
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Integer age;
    private String add;
}
