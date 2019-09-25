package com.jhly.springmvcDemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Auther:JHLY
 * @Date:2019/9/24
 * @Description:com.jhly.springmvcDemo.listener
 * @Version:1.0
 */
@WebListener
public class HelloListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized·············································");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed·············································");
    }
}
