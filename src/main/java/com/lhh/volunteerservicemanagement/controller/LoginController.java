package com.lhh.volunteerservicemanagement.controller;

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
    private Integer login( LoginRequst request, HttpSession session){
        String name = request.getUsername();
        String id = request.getPassword();
        User tname = userService.loginPage(name,id);
        System.out.println(tname);
        if (tname==null){
            return 500;
        }else {
            session.setAttribute("tname",tname.getUsername());
            return 200;
        }
//        if(tname == null){
//            mv.clear();
//            mv.setViewName("Login2");
//            return mv;
//        }else {
//            session.setAttribute("tname",tname.getUsername());
//            System.out.println(tname.getUsername());
//            //验证通过转跳首页
//            mv.setViewName("homePage");
//            return mv;
//        }
    }

}
