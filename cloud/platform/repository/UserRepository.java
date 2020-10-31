package com.cloud.platform.repository;

import com.cloud.platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

//持久化对象User作为CrudRepository的第一个类型参数，Integer作为JpaRepository用法的第二个类型参数
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 根据email和password查询用户是否存在
      * @param email
     * @param password
     * @return
     */
    List<User> findByEmailAndPassword(String email,String password);
}
