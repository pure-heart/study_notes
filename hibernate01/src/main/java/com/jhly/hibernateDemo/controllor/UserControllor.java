package com.jhly.hibernateDemo.controllor;

import com.jhly.hibernateDemo.model.User;
import com.jhly.hibernateDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther:JHLY
 * @Date:2019/9/24
 * @Description:com.jhly.hibernateDemo.controllor
 * @Version:1.0
 */
@Controller
public class UserControllor {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String sayHello(HttpServletRequest request,
                           Model model){
        User user = userService.getUser(11);
        return "helloworld"+user.getUname();
    }
}
