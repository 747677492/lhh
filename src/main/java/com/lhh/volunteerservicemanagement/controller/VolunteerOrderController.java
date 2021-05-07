package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.entity.VolunteerOrder;
import com.lhh.volunteerservicemanagement.service.VolunteerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/26 10:32
 * 概要：
 */
@RestController
@RequestMapping(value = "/volunteer")
public class VolunteerOrderController {

    @Autowired
    private VolunteerOrderService volunteerOrderService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = volunteerOrderService.search(map);
        return result;
    }

    // 获取所有数据
    public List<VolunteerOrder> searchAll() {
        List<VolunteerOrder> list = volunteerOrderService.searchAll();
        return list;
    }
    // 添加
    @RequestMapping("/add")
    public Result add(@RequestBody VolunteerOrder volunteerOrder){
        volunteerOrderService.add(volunteerOrder);
        return new Result(true, StatusCode.OK, MessageConstant.VOLUNTEER_ADD_SUCCESS);
    }

    // 根据ID查询
    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id){
        VolunteerOrder volunteerOrder = volunteerOrderService.findByID(id);
        return new Result(true,StatusCode.OK,MessageConstant.VOLUNTEER_FIND_BY_ID_SUCCESS,volunteerOrder);
    }

    // 更新
    @RequestMapping("/update")
    public Result update(@RequestBody VolunteerOrder volunteerOrder){
        volunteerOrderService.update(volunteerOrder);
        return new Result(true,StatusCode.OK,MessageConstant.VOLUNTEER_UPDATE_SUCCESS);
    }

    // 删除
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        volunteerOrderService.delete(ids);
        return new Result(true,StatusCode.OK,MessageConstant.VOLUNTEER_DELETE_SECCESS);
    }
}
