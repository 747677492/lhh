package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.entity.ShenHe;
import com.lhh.volunteerservicemanagement.service.ShenHeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/30 0:01
 * 概要：
 */
@RestController
@RequestMapping("/shenHe")
public class ShenHeController {

    @Autowired
    private ShenHeService shenHeService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = shenHeService.search(map);
        return result;
    }
    // 获取所有数据
    @RequestMapping("/searchAll")
    public List<ShenHe> searchAll(){
        List<ShenHe> list = shenHeService.searchAll();
        return list;
    }
    // 添加数据
    @RequestMapping("/add")
    public Result search(@RequestBody ShenHe shenHe){
        shenHeService.add(shenHe);
        return new Result(true, StatusCode.OK, MessageConstant.SHENHE_ADD_SUCCESS,shenHe);
    }

    // 根据id查询
    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) {
        ShenHe shenHe = shenHeService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.SHENHE_FIND_BY_ID_SUCCESS, shenHe);
    }

    // 更新
    @RequestMapping("/update")
    public Result update(@RequestBody ShenHe shenHe){
        shenHeService.update(shenHe);
        return new Result(true,StatusCode.OK,MessageConstant.SHENHE_UPDATE_SUCCESS);
    }

    // 删除
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        shenHeService.delete(ids);
        return new Result(true,StatusCode.OK,MessageConstant.SHENHE_DELETE_SUCCESS);
    }
}
