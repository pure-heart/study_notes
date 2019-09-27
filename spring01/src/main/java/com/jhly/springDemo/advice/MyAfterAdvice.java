package com.jhly.springDemo.advice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 后置通知
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.springDemo.advice
 * @Version:1.0
 */
public class MyAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("方法返回值："+returnValue);
        System.out.println("切点方法对象:"+method+",方法名："+method.getName());
        if(args!=null&&args.length>0) {
            System.out.println("切点方法参数:" + args[0]);
        }else{
            System.out.println("切点无参数");
        }
        System.out.println("对象:"+target);
        System.out.println("执行后置通知");
    }
}
