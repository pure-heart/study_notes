package com.jhly.ssm.mapper;

import com.jhly.ssm.model.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/30
 * @Description:com.jhly.ssm.mapper
 * @Version:1.0
 */

public interface StudentMapper {
    @Select("select s.*,t.id 'teacher.id',t.tname 'teacher.tname' from student s left join teacher t on s.tid =t.id")
    List<Student> selectAll();
}
