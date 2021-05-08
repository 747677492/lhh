package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.controller.request.LoginRequst;
import com.lhh.volunteerservicemanagement.entity.User;
import com.lhh.volunteerservicemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author lhh
 * @date 2021/4/26 15:20
 * 概要：
 */
@RestController
public class LoginController implements WebMvcConfigurer {

    @Autowired
    private UserService userService;
//    /**
//     * 返回管理员主页信息
//     * @param registry
//     */
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/").setViewName("forward:index.html");
//    }
    @RequestMapping(value = "/login")
    public String login(){
        System.out.println("sss");
        return "loginPage";
    }

    @RequestMapping(value = "/success",method = {RequestMethod.POST,RequestMethod.GET})
    private String ok(){
        return "success";
    }


    @RequestMapping(value = "/loginPage",method = {RequestMethod.POST,RequestMethod.GET})
    private Result login(LoginRequst request, HttpSession session){
        String name = request.getUsername();
        String password = request.getPassword();
        String role = request.getRole();
        User tname = userService.loginPage(name,password,role);
        System.out.println(tname);

        if (tname==null){
            return new Result(false,500,"账号或密码错误！");
        }else {
            session.setAttribute("tname",tname.getUsername());
            if ("admin".equals(role)){
                return new Result(true,200,"./index.html");
            }else if ("user".equals(role)){
                return new Result(true,200,"./volunteer_index.html");
            }else {
                return new Result(true,200,"./team_index.html");
            }
        }
    }

}
