package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.entity.Role;
import com.lhh.volunteerservicemanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/27 0:23
 * 概要：
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = roleService.search(map);
        return result;
    }

    //查询所有数据
    @RequestMapping("/searchAll")
    public List<Role> searchAll(){
        List<Role> list = roleService.searchAll();
        return list;
    }

    // 添加
    @RequestMapping("/add")
    public Result add(@RequestBody Role role){
        roleService.add(role);
        return new Result(true, StatusCode.OK, MessageConstant.ROLE_ADD_SUCCESS);
    }

    // 更新
    @RequestMapping("/update")
    public Result update(@RequestBody Role role){
        roleService.update(role);
        return new Result(true,StatusCode.OK, MessageConstant.ROLE_UPDATE_SUCCESS);
    }

    // 删除
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        roleService.delete(ids);
        return new Result(true,StatusCode.OK,MessageConstant.ROLE_DELETE_SUCCESS);
    }

}
