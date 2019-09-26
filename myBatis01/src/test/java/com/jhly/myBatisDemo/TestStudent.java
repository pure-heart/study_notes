package com.jhly.myBatisDemo;

import com.jhly.myBatisDemo.mapper.StudentMapper;
import com.jhly.myBatisDemo.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/26
 * @Description:com.jhly.myBatisDemo
 * @Version:1.0
 */
public class TestStudent {
    @Test
    public void selectStu() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        /*
        接口为什么能实例化：
        使用jdk的动态代理模式（面向接口的代理模式，必须有接口）
         */
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.selectAll();
        List<Student> studentList = studentMapper.selectBySidAndSname(1, "黑呆");
        List<Student> students1 = studentMapper.selectBySidAndAge(1, "17");
        for (Student student:students1) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void selectST() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.selectST();
        for (Student student:students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
