package com.jhly.springmvcDemo.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * @Auther:JHLY
 * @Date:2019/9/28
 * @Description:com.jhly.springmvcDemo.controller
 * @Version:1.0
 */
public class DemoController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("执行了spring-mvc的控制器");
        ModelAndView modelAndView = new ModelAndView("main");
        return modelAndView;
    }
}
