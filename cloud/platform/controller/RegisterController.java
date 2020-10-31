package com.cloud.platform.controller;

import com.cloud.platform.entity.User;
import com.cloud.platform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class RegisterController {
    //注入UserService
    @Resource
    private UserService userService;

    @PostMapping("register")
    public ModelAndView register(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            ModelAndView mv){
        User user =new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userService.save(user);

        System.out.println("RegisterController login 方法被调用……");
        System.out.println("RegisterController "+"注册用户名"+username+"邮箱："+email +"密码："+password);
        //重定向到index.html
        mv.setViewName("redirect:/login");
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String success() {
        return "page-register";
    }
}
