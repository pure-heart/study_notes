package com.jhly.excel_operation.dao;

import com.jhly.excel_operation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/10/18
 * @Description:com.jhly.excel_operation.dao
 * @Version:1.0
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAll();
}
