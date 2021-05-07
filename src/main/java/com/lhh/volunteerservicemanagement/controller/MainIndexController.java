package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author lhh
 * @date 2021/4/27 10:51
 * 概要：
 */
@RestController
public class MainIndexController {

    @RequestMapping(value = "/team")
    public ModelAndView toTeamIndex(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/team_index.html");
        return mv;
    }
    @RequestMapping("/user")
    public ModelAndView toVolunteerIndex(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/volunteer_index.html");
        return mv;
    }

    @RequestMapping("/manager")
    public ModelAndView toManagerIndex(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/manager_index.html");
        return mv;
    }
}
