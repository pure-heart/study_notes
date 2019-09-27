package com.jhly.myBatisDemo.mapper;

import com.jhly.myBatisDemo.model.PageInfo;
import com.jhly.myBatisDemo.model.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    List<Student> selectAuto();

    @Select("        select s.*,t.id 'teacher.id',t.tname 'teacher.tname'\n" +
            "        from student s left join teacher t\n" +
            "        on s.tid = t.id")
    List<Student> selectUnion();

    @Select("select * from student where tid = #{id}")
    List<Student> selectByTida(@Param("id") int id);
}
