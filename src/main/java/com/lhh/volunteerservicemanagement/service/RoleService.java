package com.lhh.volunteerservicemanagement.service;

import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.entity.Role;
import com.lhh.volunteerservicemanagement.entity.TeamDepartment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/27 0:20
 * 概要：
 */
public interface RoleService {

    public PageResult search(Map searchMap);

    // 添加
    Boolean add(Role role);

    // 获取所有数据
    @Transactional
    List searchAll();

    // 根据Id获取团队信息
    Role findById(Integer id);

    // 信息修改
    Boolean update(Role role);

    // 信息删除
    Boolean delete(List<Integer> ids);
}
