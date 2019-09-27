package com.jhly.springDemo.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.rmi.RemoteException;

/**
 * 异常通知
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.springDemo.advice
 * @Version:1.0
 */
public class MyThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target,Exception ex) throws Throwable{
        System.out.println("执行异常：schema-based");
    }
}
