package com.jhly.springDemo.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置通知
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.springDemo.advice
 * @Version:1.0
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("切点方法对象:"+method+",方法名："+method.getName());
        if(objects!=null&&objects.length>0) {
            System.out.println("切点方法参数:" + objects[0]);
        }else{
            System.out.println("切点无参数");
        }
        System.out.println("对象:"+o);
        System.out.println("执行前置通知");
    }
}
