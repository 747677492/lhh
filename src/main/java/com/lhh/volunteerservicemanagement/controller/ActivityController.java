package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.entity.Activity;
import com.lhh.volunteerservicemanagement.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/26 21:27
 * 概要：项目活动控制层代码
 * 处理请求与响应
 */

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = activityService.search(map);
        return result;
    }

    // 获取所有数据
    @RequestMapping("/searchAll")
    public List<Activity> searchAll(){
        List<Activity> list = activityService.searchAll();
        return list;
    }

    // 添加
    @RequestMapping("/add")
    public Result add(@RequestBody Activity activity){
        activityService.add(activity);
        return new Result(true, StatusCode.OK, MessageConstant.ACTIVITY_SEARCH_SUCCESS);
    }

    // 更新
    @RequestMapping("/update")
    public Result update(@RequestBody Activity activity){
        activityService.update(activity);
        return new Result(true,StatusCode.OK,MessageConstant.ACTIVITY_UPDATE_SUCCESS);
    }

    // 根据id查询
    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id){
        Activity activity = activityService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.ACTIVITY_FIND_BY_ID_SUCCESS,activity);
    }

    // 活动状态
    @RequestMapping("/upStatus/{status}/{id}")
    public Result upStatus(@PathVariable("status") String status, @PathVariable("id") Integer id){
        activityService.upStatus(status,id);
        return new Result(true,StatusCode.OK, MessageConstant.ACTIVITY_UPDATE_STATUS_SUCCESS);
    }

    @RequestMapping("/update1")
    public Result update1(@RequestBody Activity activity){
        activityService.update1(activity);
        return new Result(true,StatusCode.OK,MessageConstant.ACTIVITY_UPDATE_SUCCESS);
    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        activityService.delete(ids);
        return new Result(true,StatusCode.OK,MessageConstant.TEAMDEPARTMENT_DELETE_SUCCESS);
    }
}
