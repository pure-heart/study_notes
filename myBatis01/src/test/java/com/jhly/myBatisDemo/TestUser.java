package com.jhly.myBatisDemo;

import com.jhly.myBatisDemo.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/25
 * @Description:com.jhly.myBatisDemo
 * @Version:1.0
 */
public class TestUser {
    @Test
    public void test01() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //1.使用工厂设计模式 实例化对象使用的是构建者设计模式
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //2.生成session
        SqlSession sqlSession = sessionFactory.openSession();
        //3.查询操作
        List<User> users = sqlSession.selectList("com.jhly.myBatisDemo.mapper.selectAll");
        for (User user : users) {
           System.out.println("姓名："+user.getUname()+"年龄："+user.getAge());
        }
        //4.关闭session
        sqlSession.close();
    }

    @Test
    public void test02() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //1.使用工厂设计模式 实例化对象使用的是构建者设计模式
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //2.生成session
        SqlSession sqlSession = sessionFactory.openSession();
        //3.查询操作
        User user = sqlSession.selectOne("com.jhly.myBatisDemo.mapper.selectById",11);
            System.out.println("姓名："+user.getUname()+"年龄："+user.getAge());
        //4.关闭session
        sqlSession.close();
    }

    @Test
    public void test03(){
        Logger logger = Logger.getLogger(com.jhly.myBatisDemo.TestUser.class);
        logger.debug("=====================================");
    }
}
