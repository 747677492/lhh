package com.lhh.volunteerservicemanagement.service;

import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.entity.VolunteerOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/25 8:54
 * 概要：
 */
public interface VolunteerOrderService {
    public PageResult search(Map searchMap);

    //志愿者添加
    Boolean add(VolunteerOrder volunteerOrder);

    //获取所有数据
    @Transactional
    List searchAll();

    //根据志愿者ID获取志愿者信息
    VolunteerOrder findByID(Integer id);

    //志愿者信息修改
    Boolean update(VolunteerOrder volunteerOrder);

    //志愿者信息删除
    Boolean delete(List<Integer> ids);
}
