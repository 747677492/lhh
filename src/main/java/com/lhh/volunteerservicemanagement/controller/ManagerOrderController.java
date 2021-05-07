package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.entity.ManagerOrder;
import com.lhh.volunteerservicemanagement.entity.User;
import com.lhh.volunteerservicemanagement.service.ManagerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/25 10:32
 * 概要：
 */
@RestController
@RequestMapping(value = "/manager")
public class ManagerOrderController {

    @Autowired
    private ManagerOrderService managerOrderService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = managerOrderService.search(map);
        return result;
    }

    // 获取所有数据
    @RequestMapping("/searchAll")
    public List<User> searchAll(){
        List<User> list = managerOrderService.searchAll();
        return list;
    }

    // 添加
    @RequestMapping("/add")
    public Result add(@RequestBody ManagerOrder managerOrder){
        managerOrderService.add(managerOrder);
        return new Result(true, StatusCode.OK, MessageConstant.MANAGER_ADD_SUCCESS);
    }

    // 更新
    @RequestMapping("/update")
    public Result update(@RequestBody ManagerOrder managerOrder){
        managerOrderService.update(managerOrder);
        return new Result(true, StatusCode.OK, MessageConstant.MANAGER_UPDATE_SUCCESS);
    }

    // 删除
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        managerOrderService.delete(ids);
        return new Result(true,StatusCode.OK,MessageConstant.MANAGER_DELETE_SUCCESS);
    }

    // 根据Id查询
    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id){
        ManagerOrder managerOrder = managerOrderService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.MANAGER_FIND_BY_ID_SUCCESS);
    }
    @RequestMapping(value = {"/main"})
    public String managerLogin(){
        return "forward:managerLogin.html";
    }
    @RequestMapping("/")
    public String index(){
        return "forward:index.html";
    }
}
