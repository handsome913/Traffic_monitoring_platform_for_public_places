package com.cloud.platform.controller;

import com.cloud.platform.entity.User;
import com.cloud.platform.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    //注入UserService
    @Resource
    private UserService userService;

    @RequestMapping("/save")
    public String save(){
        User user =new User();
        user.setUsername("liergou");
        user.setEmail("liergou@163.com");
        user.setPassword("123456");
        userService.save(user);
        return "保存数据成功";
    }
}
