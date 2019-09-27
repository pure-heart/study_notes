package com.jhly.springDemo.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * aspectj方式实现aop
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.springDemo.advice
 * @Version:1.0
 */
public class MyAdvice {
    public void myBefore(String name,int age){
        System.out.println("前置,name="+name+" age="+age);
    }
    public void myAfter(){
        System.out.println("后置1");
    }
    public void myAftering(){
        System.out.println("后置2");
    }
    public void myThrow(){
        System.out.println("异常");
    }
    public Object myArround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("执行环绕");
        System.out.println("环绕前置");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后置");
        return proceed;

    }
}
