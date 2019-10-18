package com.jhly.excel_operation.service.imp;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.jhly.excel_operation.dao.UserRepository;
import com.jhly.excel_operation.entity.User;
import com.jhly.excel_operation.service.UserService;
import com.jhly.excel_operation.utils.ExcelUtil.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:JHLY
 * @Date:2019/10/18
 * @Description:com.jhly.excel_operation.service.imp
 * @Version:1.0
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void exportExcel(List<User> users) {
        String fileName = "用户信息.xlsx";
        //EasyExcel.write(fileName,User.class).sheet("sheet1").doWrite(users);
        //ExcelWriter excelWriter = EasyExcel.write(fileName,User.class).build();
        //WriteSheet writeSheet = EasyExcel.writerSheet("sheet1").build();
        //excelWriter.write(users,writeSheet);
        //excelWriter.finish();
        //用排序的Map且Map的键应与ExcelCell注解的index对应
        Map<String,String> map = new LinkedHashMap<>();
        map.put("id","编号");
        map.put("uname","姓名");
        map.put("upass","密码");
        map.put("age","年龄");
        map.put("remark","备注");
        map.put("createDate","创建时间");
        try {
            File file=new File(fileName);
            OutputStream out =new FileOutputStream(file);
            ExcelUtil.exportExcel(map,users,out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
