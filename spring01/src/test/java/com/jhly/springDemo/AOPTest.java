package com.jhly.springDemo;

import com.jhly.springDemo.model.AOPDemo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.springDemo
 * @Version:1.0
 */
public class AOPTest {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AOPDemo aopdemo = applicationContext.getBean("aopDemo", AOPDemo.class);
        try {
            aopdemo.demo1();
        } catch (Exception e) {
        }
        aopdemo.demo2();
        aopdemo.demo3();
        aopdemo.demo4("demo4参数");
        aopdemo.demo5("demo5参数",16);
    }
}
