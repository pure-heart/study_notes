package com.jhly.springDemo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther:JHLY
 * @Date:2019/9/28
 * @Description:com.jhly.springDemo.model
 * @Version:1.0
 */
@Component
@Data
public class People {
    private Integer id;
    private String name;
    private Set<String> sets;
    private List<String> list;
    private String[] strs;
    private Map<String,String> maps;
    private Phone phone;
}
