package com.jhly.excel_operation.controller;

import com.jhly.excel_operation.entity.User;
import com.jhly.excel_operation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/10/18
 * @Description:com.jhly.excel_operation.controller
 * @Version:1.0
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping("/exportExcel")
    public void exportExcel(){
        userService.exportExcel(userService.getAll());
    }
}
