package com.jhly.myBatisDemo.mapper;

import com.jhly.myBatisDemo.model.PageInfo;
import com.jhly.myBatisDemo.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/26
 * @Description:com.jhly.myBatisDemo.mapper
 * @Version:1.0
 */
public interface StudentMapper {
    List<Student> selectAll();
    List<Student> selectBySidAndSname(int sid,String sname);
    List<Student> selectBySidAndAge(@Param("sid") int sid, @Param("age") String age);
    List<Student> selectST();
}
