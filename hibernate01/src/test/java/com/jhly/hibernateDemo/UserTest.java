package com.jhly.hibernateDemo;

import com.jhly.hibernateDemo.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;

/**
 * @Auther:JHLY
 * @Date:2019/9/23
 * @Description:com.jhly.hibernateDemo
 * @Version:1.0
 */
public class UserTest {
    @Test
    public void addUsers(){
        //1.加载配置文件hibernate.cfg.xml
        Configuration cfg = new Configuration();
        cfg.configure();
        //2.创建SessionFactory
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        //3.得到session
        Session session =sessionFactory.openSession();
        //4.事务开启Transaction
        Transaction transaction = session.beginTransaction();
        //5.执行业务逻辑
        User user = new User();                //瞬时态
        user.setUname("阿尔托莉雅");
        user.setUpass("123456");
        user.setAge(16);
        user.setRemark("圆桌骑士团");
        user.setCreateDate(new Date());
        session.save(user);                     //持久化态
        //6.事务提交
        transaction.commit();
        //7.关闭会话session
        session.close();
    }
    @Test
    public void getUser(){
        //1.加载配置文件hibernate.cfg.xml
        Configuration cfg = new Configuration();
        cfg.configure();
        //2.创建SessionFactory 单例，线程安全，系统开销大
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        //3.得到session 多例
        Session session =sessionFactory.openSession();
        //4.事务开启Transaction
        Transaction transaction = session.beginTransaction();
        //5.执行业务逻辑
        /**
         * 通过主键查询
         * get()当查询主键不存在时，返回null，get不支持延迟加载（立刻执行所有SQL语句）
         * load()当查询主键不存在时，抛出异常ObjectNotFoundException，load支持延迟加载（按需求进行SQL语句查询）
         *
         * JPA方法：
         * find()
         * getReference()
         */
        User user = session.get(User.class, 7);
//        session.load(User.class, 1);
//        session.find(User.class,7);
//        session.getReference(User.class,7);
        System.out.println(user);
        //6.事务提交
        transaction.commit();
        //7.关闭会话session
        session.close();
    }

    @Test
    public void deleteUser(){
        Configuration cfg =new Configuration().configure();
        SessionFactory sessionFactory =cfg.buildSessionFactory();
        Session session =sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        User user =session.get(User.class,12);
        session.delete(user);
        transaction.commit();
        session.close();

    }
}
