package com.jhly.springDemo.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕通知
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.springDemo.advice
 * @Version:1.0
 */
public class MyArrountAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕前置");
        Object proceed = invocation.proceed();//放行，调用切点方式
        System.out.println("环绕后置");
        return proceed;
    }
}
