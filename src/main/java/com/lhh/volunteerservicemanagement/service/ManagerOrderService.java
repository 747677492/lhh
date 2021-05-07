package com.lhh.volunteerservicemanagement.service;

import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.dao.ManagerOrderMapper;
import com.lhh.volunteerservicemanagement.entity.ManagerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/25 8:52
 * 概要：
 */

public interface ManagerOrderService {

    // 检索支持多条件检索
    public PageResult search(Map searchMap);

    // 获取所有数据
    @Transactional
    List searchAll();

    // 添加
    Boolean add(ManagerOrder managerOrder);

    // 管理员信息修改
    Boolean update(ManagerOrder managerOrder);

    //删除
    Boolean delete(List<Integer> ids);

    // 根据Id获取信息
    ManagerOrder findById(Integer id);
}
