package com.jhly.excel_operation.service;

import com.jhly.excel_operation.entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/10/18
 * @Description:com.jhly.excel_operation.service
 * @Version:1.0
 */
public interface UserService {
    List<User> getAll();
    void exportExcel(List<User> users);
}
