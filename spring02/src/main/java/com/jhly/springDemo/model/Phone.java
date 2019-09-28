package com.jhly.springDemo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Auther:JHLY
 * @Date:2019/9/28
 * @Description:com.jhly.springDemo.model
 * @Version:1.0
 */
@Component
@Data
public class Phone {
    private Integer id;
    private Double price;
}
