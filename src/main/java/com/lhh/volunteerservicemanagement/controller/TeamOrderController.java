package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.entity.TeamOrder;
import com.lhh.volunteerservicemanagement.service.TeamOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/26 10:31
 * 概要：
 */
@RestController
@RequestMapping(value = "/team")
public class TeamOrderController {

    @Autowired
    private TeamOrderService teamOrderService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = teamOrderService.search(map);
        return result;
    }
    // 获取所有数据
    @RequestMapping("/searchAll")
    public List<TeamOrder> searchAll(){
        List<TeamOrder> list = teamOrderService.searchAll();
        return list;
    }
    // 添加数据
    @RequestMapping("/add")
    public Result add(@RequestBody TeamOrder teamOrder){
       teamOrderService.add(teamOrder);
       return new Result(true, StatusCode.OK, MessageConstant.TEAM_ADD_SUCCESS,teamOrder);
    }

    // 根据id查询
    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) {
        TeamOrder teamOrder = teamOrderService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.TEAM_FIND_BY_ID_SUCCESS, teamOrder);
    }

    // 更新
    @RequestMapping("/update")
    public Result update(@RequestBody TeamOrder teamOrder){
        teamOrderService.update(teamOrder);
        return new Result(true,StatusCode.OK,MessageConstant.TEAM_UPDATE_SUCCESS);
    }

    // 删除
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        teamOrderService.delete(ids);
        return new Result(true,StatusCode.OK,MessageConstant.TEAM_DELETE_SUCCESS);
    }
}
