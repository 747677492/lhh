package com.lhh.volunteerservicemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.dao.UserMapper;
import com.lhh.volunteerservicemanagement.entity.User;
import com.lhh.volunteerservicemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/27 0:24
 * 概要：
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult search(Map searchMap) {
        Example example = new Example(User.class);
        int pageNum = 1;//默认值
        int pageSize = 2;
        if(searchMap != null) {
            //指定查询的表
            //查询条件
            Example.Criteria criteria = example.createCriteria();
            //添加条件
            String name = (String)searchMap.get("name");
            if(StringUtil.isNotEmpty(name)){
                criteria.andLike("name","%"+name.trim()+"%");
            }
            String startTime = (String) searchMap.get("startTime");
            if(StringUtil.isNotEmpty(startTime)){
                criteria.andGreaterThanOrEqualTo("createTime",startTime);
            }
            String endTime = (String) searchMap.get("endTime");
            if(StringUtil.isNotEmpty(endTime)){
                criteria.andLessThanOrEqualTo("createTime",endTime);
            }
            if((Integer) searchMap.get("pageNum") !=null){
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if((Integer) searchMap.get("pageSize") !=null){
                pageSize = (Integer) searchMap.get("pageSize");
            }
            //特别注意：该行代码后面要紧跟要执行的查询语句
            PageHelper.startPage(pageNum,pageSize);
        }
        Page<User> page = (Page<User>) userMapper.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.USER_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @Override
    @Transactional
    public Boolean add(User user) {
        userMapper.insertSelective(user);
        return true;
    }

    @Override
    @Transactional
    public List searchAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    @Transactional
    public Boolean update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return true;
    }

    @Override
    @Transactional
    public Boolean delete(List<Integer> ids) {
        for(Integer id : ids){
            userMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    @Transactional
    public User findById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    @Transactional
    public User login(String username, String userpassword) {
        return login(username,userpassword);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getAllUserByName(String username) {
        User user = userMapper.getAllUserByName(username);
        return user;
    }

    @Override
    public User loginPage(String username, String id) {
        User user = userMapper.loginPage(username,id);
        return user;
    }
}
