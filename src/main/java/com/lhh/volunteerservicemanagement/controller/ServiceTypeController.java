package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.entity.Role;
import com.lhh.volunteerservicemanagement.entity.ServiceType;
import com.lhh.volunteerservicemanagement.service.RoleService;
import com.lhh.volunteerservicemanagement.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/30 9:27
 * 概要：
 */
@RestController
@RequestMapping("/serviceType")
public class ServiceTypeController {
    @Autowired
    private ServiceTypeService serviceTypeService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = serviceTypeService.search(map);
        return result;
    }

    //查询所有数据
    @RequestMapping("/searchAll")
    public List<ServiceType> searchAll(){
        List<ServiceType> list = serviceTypeService.searchAll();
        return list;
    }

    // 添加
    @RequestMapping("/add")
    public Result add(@RequestBody ServiceType serviceType){
        serviceTypeService.add(serviceType);
        return new Result(true, StatusCode.OK, MessageConstant.SERVICETYPE_ADD_SUCCESS);
    }

    // 更新
    @RequestMapping("/update")
    public Result update(@RequestBody ServiceType serviceType){
        serviceTypeService.update(serviceType);
        return new Result(true,StatusCode.OK, MessageConstant.SERVICETYPE_UPDATE_SUCCESS);
    }

    // 删除
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        serviceTypeService.delete(ids);
        return new Result(true,StatusCode.OK,MessageConstant.SERVICETYPE_DELETE_SUCCESS);
    }
}
