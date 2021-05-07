package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.entity.User;
import com.lhh.volunteerservicemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Retention;
import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/27 0:23
 * 概要：
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = userService.search(map);
        return result;
    }

    // 获取所有数据
    @RequestMapping("/searchAll")
    public List<User> searchAll(){
        List<User> list = userService.searchAll();
        return list;
    }

    // 添加
    @RequestMapping("/add")
    public Result add(@RequestBody User user){
        userService.add(user);
        return new Result(true, StatusCode.OK, MessageConstant.USER_ADD_SUCCESS);
    }

    // 更新
    @RequestMapping("/update")
    public Result update(@RequestBody User user){
        userService.update(user);
        return new Result(true,StatusCode.OK,MessageConstant.USER_UPDATE_SUCCESS);
    }

    // 删除
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        userService.delete(ids);
        return new Result(true,StatusCode.OK,MessageConstant.USER_DELETE_SUCCESS);
    }

    // 根据Id查询
    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id){
        User user = userService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.USER_FIND_BY_ID_SUCCESS);
    }
}
