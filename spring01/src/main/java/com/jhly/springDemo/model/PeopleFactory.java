package com.jhly.springDemo.model;

/**
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.springDemo.model
 * @Version:1.0
 */
public class PeopleFactory {
    public People newInstance(){
        return new People(1,"实例工厂创造孔明");
    }
    public static People newInstance1(){
        return new People(1,"静态工厂创造孔明");
    }
}
