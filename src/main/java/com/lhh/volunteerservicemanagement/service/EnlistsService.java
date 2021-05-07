package com.lhh.volunteerservicemanagement.service;

import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.entity.EnLists;
import com.lhh.volunteerservicemanagement.entity.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/29 11:16
 * 概要：
 */
public interface EnlistsService {

    public PageResult search(Map searchMap);

    // 添加
    Boolean add(EnLists enLists);

    // 获取所有数据
    @Transactional
    List searchAll();

    // 根据Id获取团队信息
    EnLists findById(Integer id);

    // 信息修改
    Boolean update(EnLists enLists);

    // 信息删除
    Boolean delete(List<Integer> ids);
}
