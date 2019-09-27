package com.jhly.myBatisDemo.mapper;

import com.jhly.myBatisDemo.model.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/26
 * @Description:com.jhly.myBatisDemo.mapper
 * @Version:1.0
 */
public interface TeacherMapper {

//    xml方式
    Teacher selectById(int id);
    List<Teacher> selectAll();
    List<Teacher> selectTS();
    List<Teacher> selectAuto();
//    注解方式
    @Select("select * from teacher")
    List<Teacher> selectDemo();
    @Insert("insert into teacher values (#{id},#{tname})")
    int insertDemo(Teacher teacher);
    @Update("update teacher set tname = #{tname} where id = #{id} ")
    int updateDemo(@Param("id") int id, @Param("tname") String tname);
    @Delete("delete from teacher where id = #{id}")
    int deleteDemo(@Param("id") int id);
//    关联查询
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "tname",property = "tname"),
            @Result(column = "id",property = "list",many = @Many(select = "com.jhly.myBatisDemo.mapper.StudentMapper.selectByTida"))
    })
    @Select("select * from teacher")
    List<Teacher> selectUnion();
}
