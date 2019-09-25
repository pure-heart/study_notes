package com.jhly.springmvcDemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Auther:JHLY
 * @Date:2019/9/24
 * @Description:com.jhly.springmvcDemo.filter
 * @Version:1.0
 */
@WebFilter(value = "/filter")
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter容器启动·············································");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter·············································");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy·············································");
    }
}
