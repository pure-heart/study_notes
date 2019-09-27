package com.jhly.springDemo;

import com.jhly.springDemo.model.People;
import com.jhly.springDemo.model.PeopleFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.springDemo
 * @Version:1.0
 */
public class Test {
    @org.junit.Test
public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = applicationContext.getBean("people3", People.class);
        System.out.println(people);
    }

    /**
     * 测试实例工厂模式
     */
    @org.junit.Test
    public void test02(){
        //PeopleFactory peopleFactory = new PeopleFactory();
        //People people = peopleFactory.newInstance();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = applicationContext.getBean("people1", People.class);
        System.out.println(people);
    }

    /**
     * 测试静态工厂模式
     */
    @org.junit.Test
    public void test03(){
//        People people = PeopleFactory.newInstance1();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = applicationContext.getBean("people2", People.class);
        System.out.println(people);
    }
}
