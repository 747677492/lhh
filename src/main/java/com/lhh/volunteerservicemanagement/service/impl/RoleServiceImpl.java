package com.lhh.volunteerservicemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.dao.RoleMapper;
import com.lhh.volunteerservicemanagement.entity.Role;
import com.lhh.volunteerservicemanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/29 11:24
 * 概要：
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageResult search(Map searchMap) {
        Example example = new Example(Role.class);
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
        Page<Role> page = (Page<Role>) roleMapper.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.ROLE_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @Override
    @Transactional
    public Boolean add(Role role) {
        roleMapper.insertSelective(role);
        return true;
    }

    @Override
    @Transactional
    public List searchAll() {
        List<Role> roles = roleMapper.selectAll();
        return roles;
    }

    @Override
    @Transactional
    public Role findById(Integer id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        return role;
    }

    @Override
    @Transactional
    public Boolean update(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
        return true;
    }

    @Override
    @Transactional
    public Boolean delete(List<Integer> ids) {
        for (Integer id : ids){
            roleMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
