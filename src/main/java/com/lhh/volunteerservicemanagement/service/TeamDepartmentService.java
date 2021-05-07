package com.lhh.volunteerservicemanagement.service;

import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.entity.TeamDepartment;
import com.lhh.volunteerservicemanagement.entity.TeamOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/29 11:04
 * 概要：
 */

public interface TeamDepartmentService {

    public PageResult search(Map searchMap);

    // 团队添加
    Boolean add(TeamDepartment teamDepartment);

    // 获取所有数据
    @Transactional
    List searchAll();

    // 根据团队Id获取团队信息
    TeamDepartment findById(Integer id);

    // 团队信息修改
    Boolean update(TeamDepartment teamDepartment);

    // 团队信息删除
    Boolean delete(List<Integer> ids);
}
