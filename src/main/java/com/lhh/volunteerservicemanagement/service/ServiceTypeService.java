package com.lhh.volunteerservicemanagement.service;

import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.entity.ServiceType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/25 8:53
 * 概要：
 */
public interface ServiceTypeService {

    public PageResult search(Map map);

    // 添加
    Boolean add(ServiceType serviceType);

    // 获取所有数据
    @Transactional
    List searchAll();

    // 根据id查询信息
    ServiceType findById(Integer id);

    // 更新
    Boolean update(ServiceType serviceType);

    // 删除
    Boolean delete(List<Integer> ids);
}
