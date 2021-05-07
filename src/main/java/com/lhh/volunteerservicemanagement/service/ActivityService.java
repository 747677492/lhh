package com.lhh.volunteerservicemanagement.service;

import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.dao.ManagerOrderMapper;
import com.lhh.volunteerservicemanagement.entity.Activity;
import com.lhh.volunteerservicemanagement.entity.ManagerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/25 8:52
 * 概要：
 */
public interface ActivityService {

    // 支持多条件检索
    public PageResult search(Map searchMap);

    // 添加活动
    Boolean add(Activity activity);

    //获取所有数据
    @Transactional
    List searchAll();

    // 根据Id获取活动信息
    Activity findById(Integer id);

    // 活动信息修改
    Boolean update(Activity activity);

    // 活动信息删除
    Boolean delete(List<Integer> ids);

    // 启用活动状态
    Boolean upStatus(String status,Integer id);

    Boolean update1(Activity activity);

}
