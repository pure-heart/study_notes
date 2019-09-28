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
    /**
     * 构造方法创建
     */
    @org.junit.Test
public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = applicationContext.getBean("people", People.class);
        System.out.println(people);
    }

    /**
     * 测试实例工厂模式创建
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
     * 测试静态工厂模式创建
     */
    @org.junit.Test
    public void test03(){
//        People people = PeopleFactory.newInstance1();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = applicationContext.getBean("people2", People.class);
        System.out.println(people);
    }

    /**
     * 测试bean属性赋值
     */
    @org.junit.Test
    public void test04(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = applicationContext.getBean("people3", People.class);
        System.out.println(people);
    }

    /**
     * 测试自动注入
     */
    @org.junit.Test
    public void test05(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = applicationContext.getBean("people4", People.class);
        System.out.println(people);
    }
    /**
     * 测试scope范围
     */
    @org.junit.Test
    public void test06(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people1 = applicationContext.getBean("people5", People.class);
        People people2 = applicationContext.getBean("people5", People.class);
        System.out.println(people1==people2);
    }
}
