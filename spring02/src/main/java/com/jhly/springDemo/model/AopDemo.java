package com.jhly.springDemo.model;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther:JHLY
 * @Date:2019/9/28
 * @Description:com.jhly.springDemo.model
 * @Version:1.0
 */
@Component
public class AopDemo {
    @Value("${jdbc.url}")
    private String db;

    @Pointcut("execution(* com.jhly.springDemo.model.AopDemo.demo1())")
    public void demo1() {
//        int i =5/0;
        System.out.println("demo1");
    }

    public void demo2() {
        System.out.println(db);
    }

    public void demo3() {
        System.out.println("demo3");
    }

    public void demo4(String name) {
        System.out.println("demo4");
    }

    public String demo5(String name,int age) {
        System.out.println("demo5");
        return "demo5的返回值";
    }
}
