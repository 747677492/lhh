package com.lhh.volunteerservicemanagement.controller;

import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.Result;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.entity.Notice;
import com.lhh.volunteerservicemanagement.service.NoticeService;
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
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = noticeService.search(map);
        return result;
    }
    // 获取所有数据
    @RequestMapping("/searchAll")
    public List<Notice> searchAll(){
        List<Notice> list = noticeService.searchAll();
        return list;
    }
    // 添加数据
    @RequestMapping("/add")
    public Result search(@RequestBody Notice notice){
        noticeService.add(notice);
        return new Result(true, StatusCode.OK, MessageConstant.NOTICE_ADD_SUCCESS,notice);
    }

    // 根据id查询
    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) {
        Notice notice = noticeService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.NOTICE_FIND_BY_ID_SUCCESS, notice);
    }

    // 更新
    @RequestMapping("/update")
    public Result update(@RequestBody Notice notice){
        noticeService.update(notice);
        return new Result(true,StatusCode.OK,MessageConstant.NOTICE_UPDATE_SUCCESS);
    }

    // 删除
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        noticeService.delete(ids);
        return new Result(true,StatusCode.OK,MessageConstant.NOTICE_DELETE_SUCCESS);
    }
}
