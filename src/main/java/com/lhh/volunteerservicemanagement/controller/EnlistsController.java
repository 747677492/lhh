package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.entity.EnLists;
import com.lhh.volunteerservicemanagement.entity.TeamOrder;
import com.lhh.volunteerservicemanagement.service.EnlistsService;
import com.lhh.volunteerservicemanagement.service.TeamOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/30 0:00
 * 概要：
 */
@RestController
@RequestMapping("/enlists")
public class EnlistsController {

    @Autowired
    private EnlistsService enlistsService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = enlistsService.search(map);
        return result;
    }
    // 获取所有数据
    @RequestMapping("/searchAll")
    public List<TeamOrder> searchAll(){
        List<TeamOrder> list = enlistsService.searchAll();
        return list;
    }
    // 添加数据
    @RequestMapping("/add")
    public Result search(@RequestBody EnLists enlists){
        enlistsService.add(enlists);
        return new Result(true, StatusCode.OK, MessageConstant.ENLISTS_ADD_SUCCESS,enlists);
    }

    // 根据id查询
    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) {
        EnLists enlists = enlistsService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.ENLISTS_FIND_BY_ID_SUCCESS, enlists);
    }

    // 更新
    @RequestMapping("/update")
    public Result update(@RequestBody EnLists enlists){
        enlistsService.update(enlists);
        return new Result(true,StatusCode.OK,MessageConstant.ENLISTS_UPDATE_SUCCESS);
    }

    // 删除
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        enlistsService.delete(ids);
        return new Result(true,StatusCode.OK,MessageConstant.ENLISTS_DELETE_SUCCESS);
    }
}
