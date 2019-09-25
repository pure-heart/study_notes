package com.jhly.hibernateDemo.service;

import com.jhly.hibernateDemo.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

/**
 * @Auther:JHLY
 * @Date:2019/9/24
 * @Description:com.jhly.hibernateDemo.service
 * @Version:1.0
 */
@Service
public class UserService {

    public User getUser(int id){
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session =sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }

}
