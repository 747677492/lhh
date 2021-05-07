package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.dao.TeamDepartmentMapper;
import com.lhh.volunteerservicemanagement.entity.TeamDepartment;
import com.lhh.volunteerservicemanagement.service.TeamDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/30 0:02
 * 概要：
 */
@RestController
@RequestMapping("/teamDepartment")
public class TeamDepartmentController {

    @Autowired
    private TeamDepartmentService teamDepartmentService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = teamDepartmentService.search(map);
        return result;
    }

    // 获取所有数据
    @RequestMapping("/searchAll")
    public List<TeamDepartment> searchAll(){
        List<TeamDepartment> list = teamDepartmentService.searchAll();
        return list;
    }

    // 添加
    @RequestMapping("/add")
    public Result add(@RequestBody TeamDepartment teamDepartment){
        teamDepartmentService.add(teamDepartment);
        return new Result(true, StatusCode.OK, MessageConstant.TEAMDEPARTMENT_ADD_SUCCESS);
    }

    // 根据Id查询
    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id){
        TeamDepartment teamDepartment = teamDepartmentService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.TEAMDEPARTMENT_FIND_BY_ID_SUCCESS,teamDepartment);
    }

    // 更新
    public Result update(@RequestBody TeamDepartment teamDepartment){
        teamDepartmentService.update(teamDepartment);
        return new Result(true,StatusCode.OK,MessageConstant.TEAMDEPARTMENT_UPDATE_SUCCESS);
    }

    // 删除
    public Result delete(@RequestBody List<Integer> ids){
        teamDepartmentService.delete(ids);
        return new Result(true,StatusCode.OK,MessageConstant.TEAMDEPARTMENT_DELETE_SUCCESS);
    }




}
