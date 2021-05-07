package com.lhh.volunteerservicemanagement.service;

import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/27 0:21
 * 概要：
 */
public interface UserService {

    //检索支持多条件检索
    public PageResult search(Map searchMap);

    // 添加
    Boolean add(User user);

    // 获取所有数据
    @Transactional
    List searchAll();

    // 信息修改
    Boolean update(User user);

    // 删除信息
    Boolean delete(List<Integer> ids);

    //根据ID获取信息
    User findById(Integer id);

    // 登录
    public User login(String username,String userpassword);

    List<User> getAllUser();

    @Select("select username,id from user where username=#{username}")
    User getAllUserByName(@Param("username") String username);

    User loginPage(String username,String id);

}
