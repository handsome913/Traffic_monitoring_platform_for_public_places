package com.cloud.platform.service;

import com.cloud.platform.entity.User;
import com.cloud.platform.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //注入UserRepository
    @Resource
    private UserRepository userRepository;

    /**
       save、 update、 delete方法需要绑定事务。使用@Transactional进行事务绑定

       保存对象
       @param user
       @return 包含自动生成的id的User对象
     */
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * 查询所有数据
     * @return 返回所有User对象
     */
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }
    /**
     * 根据id查询数据
     * @return 返回id对应的User对象
     */
    public User getById(Integer id) {
        //根据id查询对应的持久化对象
        Optional<User> op = userRepository.findById(id);
        return op.get();
    }

    /**
     * 根据email 和password 来判断用户是否存在，用于登录查询
     * @param email
     * @param password
     * @return
     */
    public boolean isUserExist(String email, String password){

        List<User> ulist= userRepository.findByEmailAndPassword(email,password);
        return !ulist.isEmpty();
    }
    /**
     *  根据id删除数据
     * @param id
     */
    @Transactional
    public void delete(int id){
        userRepository.deleteById(id);
    }

    @Transactional
    public void update(User user) {
        //直接调用持久化对象的set方法修改对象数据
    }
}
