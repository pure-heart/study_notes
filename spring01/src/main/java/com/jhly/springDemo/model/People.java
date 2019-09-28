package com.jhly.springDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.springDemo.model
 * @Version:1.0
 */
@Data
public class People {
    private Integer id;
    private String name;
    private Set<String> sets;
    private List<String> list;
    private String[] strs;
    private Map<String,String> maps;
    private Phone phone;

    public People() {
        System.out.println("通过无参构造方法");
    }

    public People(Integer id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("通过有参构造方法");
    }

    public People(Phone phone) {
        this.phone = phone;
        System.out.println("通过有参构造方法1");
    }
}
