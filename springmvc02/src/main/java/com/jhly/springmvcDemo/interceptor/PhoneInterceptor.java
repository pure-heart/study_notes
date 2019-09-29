package com.jhly.springmvcDemo.interceptor;

import com.jhly.springmvcDemo.model.People;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器：发送请求时拦截，在控制器前后添加额外功能
 * 与AOP的区别：AOP拦截spring管理的任一特定方法，拦截器只针对控制器方法
 * 与过滤器的区别：过滤器拦截任意请求，拦截器器只针对controller，控制器生效拦截器才生效
 */

/**
 * @Auther:JHLY
 * @Date:2019/9/29
 * @Description:com.jhly.springmvcDemo.interceptor
 * @Version:1.0
 */
public class PhoneInterceptor implements HandlerInterceptor {
    /**
     * 在进入控制器之前执行，返回值为false阻止进入控制器
     * @param request
     * @param response
     * @param handler:拦截的控制器方法
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle11111111111111111111111111111111111111111111");
        return true;
    }

    /**
     * 控制器执行完成进入jsp之前执行
     * 常用作日志记录和敏感词过滤
     * @param request
     * @param response
     * @param handler:拦截的控制器方法
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        People people = (People) modelAndView.getModelMap().get("people");
        people.setAge(17);
        modelAndView.setViewName("index");
        modelAndView.getModelMap().put("people",people);
        System.out.println(modelAndView.getModel());
        String viewName = modelAndView.getViewName();
        System.out.println(viewName);
        System.out.println("postHandle11111111111111111111111111111111111111111111111111");
    }

    /**
     * jsp执行完成后执行
     * 用于记录执行过程中的异常 可以把异常记录到日志中
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion11111111111111111111111111111111111111");
    }
}
