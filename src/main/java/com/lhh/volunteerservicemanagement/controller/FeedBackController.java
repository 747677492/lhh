package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.entity.EnLists;
import com.lhh.volunteerservicemanagement.entity.FeedBack;
import com.lhh.volunteerservicemanagement.entity.TeamOrder;
import com.lhh.volunteerservicemanagement.service.EnlistsService;
import com.lhh.volunteerservicemanagement.service.FeedBackService;
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
@RequestMapping("/feedBack")
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = feedBackService.search(map);
        return result;
    }
    // 获取所有数据
    @RequestMapping("/searchAll")
    public List<FeedBack> searchAll(){
        List<FeedBack> list = feedBackService.searchAll();
        return list;
    }
    // 添加数据
    @RequestMapping("/add")
    public Result search(@RequestBody FeedBack feedBack){
        feedBackService.add(feedBack);
        return new Result(true, StatusCode.OK, MessageConstant.FEEDBACK_ADD_SUCCESS,feedBack);
    }

    // 根据id查询
    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) {
        FeedBack feedBack = feedBackService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.FEEDBACK_FIND_BY_ID_SUCCESS, feedBack);
    }

    // 更新
    @RequestMapping("/update")
    public Result update(@RequestBody FeedBack feedBack){
        feedBackService.update(feedBack);
        return new Result(true,StatusCode.OK,MessageConstant.FEEDBACK_UPDATE_SUCCESS);
    }

    // 删除
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        feedBackService.delete(ids);
        return new Result(true,StatusCode.OK,MessageConstant.FEEDBACK_DELETE_SUCCESS);
    }

}
