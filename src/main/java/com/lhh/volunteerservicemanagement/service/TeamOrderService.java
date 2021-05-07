package com.lhh.volunteerservicemanagement.service;

import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.entity.TeamOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/25 8:53
 * 概要：
 */
public interface TeamOrderService {

    public PageResult search(Map searchMap);

    // 团队添加
    Boolean add(TeamOrder teamOrder);

    // 获取所有数据
    @Transactional
    List searchAll();

    // 根据团队Id获取团队信息
    TeamOrder findById(Integer id);

    // 团队信息修改
    Boolean update(TeamOrder teamOrder);

    // 团队信息删除
    Boolean delete(List<Integer> ids);
}
