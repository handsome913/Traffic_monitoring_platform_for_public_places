package com.cloud.platform.controller;

import com.cloud.platform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class LoginController {
    //注入UserService
    @Resource
    private UserService userService;

    @PostMapping("login")
    public ModelAndView login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            ModelAndView mv){

        System.out.println("LoginController login 方法被调用……");
        System.out.println("LoginController 登录邮箱："+email +"密码："+password);
        if(userService.isUserExist(email,password)){
           //登录成功重定向到index.html
           mv.setViewName("redirect:/");
        }
        else
            mv.setViewName("redirect:/login");
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String success() {
        return "page-login";
    }
}
