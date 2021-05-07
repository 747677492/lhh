package com.lhh.volunteerservicemanagement.service;

import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.entity.ShenHe;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/27 0:21
 * 概要：
 */
public interface ShenHeService {

    public PageResult search(Map map);

    // 添加
    Boolean add(ShenHe shenHe);

    // 获取所有数据
    @Transactional
    List searchAll();

    // 根据id获取信息
    ShenHe findById(Integer id);

    // 更新
    Boolean update(ShenHe shenHe);

    // 删除
    Boolean delete(List<Integer> ids);

}
