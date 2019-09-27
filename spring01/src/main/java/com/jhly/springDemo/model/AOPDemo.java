package com.jhly.springDemo.model;

/**
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.springDemo.model
 * @Version:1.0
 */
public class AOPDemo {

    public void demo1() {
        int i =5/0;
        System.out.println("demo1");
    }

    public void demo2() {
        System.out.println("demo2");
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
