package com.jhly.springDemo.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Auther:JHLY
 * @Date:2019/9/28
 * @Description:com.jhly.springDemo.advice
 * @Version:1.0
 */
@Component
@Aspect
public class MyAdvice {

    @Before("com.jhly.springDemo.model.AopDemo.demo1()")
    public void myBefore(){
        System.out.println("前置通知");
    }
    @After("com.jhly.springDemo.model.AopDemo.demo1()")
    public void myAfter(){
        System.out.println("后置通知");
    }
    @AfterThrowing("com.jhly.springDemo.model.AopDemo.demo1()")
    public void myThrow(){
        System.out.println("异常通知");
    }
    @Around("com.jhly.springDemo.model.AopDemo.demo1()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前置");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后置");
        return proceed;
    }
}
