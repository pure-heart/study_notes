package com.jhly.springmvcDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Auther:JHLY
 * @Date:2019/9/29
 * @Description:com.jhly.springmvcDemo.model
 * @Version:1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class People {
    private String name;
    private Integer age;
}
