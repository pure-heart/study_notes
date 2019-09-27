package com.jhly.myBatisDemo;

import com.jhly.myBatisDemo.mapper.TeacherMapper;
import com.jhly.myBatisDemo.model.Teacher;
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
 * @Date:2019/9/27
 * @Description:com.jhly.myBatisDemo
 * @Version:1.0
 */
public class TestTeacher {
    /**
     * 一对多
     */
    @Test
    public void test01() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = teacherMapper.selectAll();
        List<Teacher> teachers1 = teacherMapper.selectTS();
        List<Teacher> teachers2 = teacherMapper.selectAuto();
        List<Teacher> teachers3 = teacherMapper.selectDemo();
        for (Teacher teacher : teachers3
        ) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }
    @Test
    public void test02() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher t = new Teacher(3,"商鞅",null);
        System.out.println(teacherMapper.insertDemo(t));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test03() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        System.out.println(teacherMapper.updateDemo(3,"吉尔伽美什"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test04() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        System.out.println(teacherMapper.deleteDemo(3));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test05() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        System.out.println(teacherMapper.selectUnion());
        sqlSession.commit();
        sqlSession.close();
    }
}
