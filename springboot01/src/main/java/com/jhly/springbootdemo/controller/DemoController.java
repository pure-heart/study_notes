package com.jhly.springbootdemo.controller;

import com.jhly.springbootdemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:JHLY
 * @Date:2019/10/1
 * @Description:com.jhly.springbootdemo.springboot01.controller
 * @Version:1.0
 */
@RestController
public class DemoController {
    //获取配置文件的内容
    @Value("${person.name}")
    private String name ;

    @Autowired
    private Person person;

    @RequestMapping("/")
    public String demo01(){
        return "hello springboot! "+person;
    }
}
