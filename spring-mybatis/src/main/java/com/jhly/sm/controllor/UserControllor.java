package com.jhly.sm.controllor;

import com.jhly.sm.model.User;
import com.jhly.sm.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:com.jhly.sm.controllor
 * @Version:1.0
 */
@WebServlet("/user")
public class UserControllor extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        //spring和web整合后所有信息都放在ApplicationContext中
        ServletContext servletContext = getServletContext();
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        userService = applicationContext.getBean("userService",UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.show();
        System.out.println(users);
        req.setAttribute("users",users);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
