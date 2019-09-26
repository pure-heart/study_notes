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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:JHLY
 * @Date:2019/9/25
 * @Description:com.jhly.myBatisDemo
 * @Version:1.0
 */
public class TestUser {
    /**
     * 查询所有
     * @throws IOException
     */
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

    /**
     * 参数为基本数据类型
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //1.使用工厂设计模式 实例化对象使用的是构建者设计模式
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //2.生成session
        SqlSession sqlSession = sessionFactory.openSession();
        //3.查询操作
        Map<String,Object> map = new HashMap<>();
        map.put("id",11);
        map.put("name","阿尔托莉雅");
        User user = sqlSession.selectOne("com.jhly.myBatisDemo.mapper.selectById",11);
            System.out.println("姓名："+user.getUname()+"年龄："+user.getAge());
        //4.关闭session
        sqlSession.close();
    }

    /**
     * 测试log4j的基本用法
     */
    @Test
    public void test03(){
        Logger logger = Logger.getLogger(com.jhly.myBatisDemo.TestUser.class);
        logger.info("测试log功能");
        logger.debug("=====================================");
    }

    /**
     * 参数为map
     * @throws IOException
     */
    @Test
    public void test04() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //1.使用工厂设计模式 实例化对象使用的是构建者设计模式
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //2.生成session
        SqlSession sqlSession = sessionFactory.openSession();
        //3.查询操作
        //如果希望传递多个参数，可以使用对象或map
        //map
//        Map<String,Object> map = new HashMap<>();
//        map.put("id","39");
//        map.put("name","莫德雷德");
//        User user = sqlSession.selectOne("com.jhly.myBatisDemo.mapper.selectByIdAndName",map);
//        System.out.println(user);
        //对象
        User user1 = new User();
        user1.setId(39);
        user1.setUname("莫德雷德");
        User user2 = sqlSession.selectOne("com.jhly.myBatisDemo.mapper.selectByIdAndName",user1);
        System.out.println(user2);
        //4.关闭session
        sqlSession.close();
    }

    /**
     * 分页查询
     * @throws IOException
     */
    @Test
    public void test05() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //1.使用工厂设计模式 实例化对象使用的是构建者设计模式
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //2.生成session
        SqlSession sqlSession = sessionFactory.openSession();
        //3.查询操作
        int pageSize = 5;
        int pageNumber = 2;
        Map<String,Object> map = new HashMap<>();
        //每页条数
        map.put("pageSize",pageSize);
        //显示页数
        map.put("pageStart",pageSize*(pageNumber-1));
        //如果希望传递多个参数，可以使用对象或map
        List<User> users = sqlSession.selectList("com.jhly.myBatisDemo.mapper.page",map);
        System.out.println(users);
        //4.关闭session
        sqlSession.close();
    }

    /**
     * 新增一条数据
     * @throws IOException
     */
    @Test
    public void test06() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //1.使用工厂设计模式 实例化对象使用的是构建者设计模式
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //2.生成session 默认事务不自动提交
        SqlSession sqlSession = sessionFactory.openSession();
        //3.新增操作
        User user =new User();
        user.setUname("莫德雷德");
        user.setAge(17);
        user.setUpass("123");
        user.setRemark("圆桌骑士");
        user.setCreateDate(new Date());
        int i = 0;
        try {
            i = sqlSession.insert("com.jhly.myBatisDemo.mapper.add", user);
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        System.out.println(i);
        //4.提交事务
        sqlSession.commit();
        //5.关闭session
        sqlSession.close();
        test01();
    }
}
