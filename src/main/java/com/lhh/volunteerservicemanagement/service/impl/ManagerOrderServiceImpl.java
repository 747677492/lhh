package com.lhh.volunteerservicemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.dao.ManagerOrderMapper;
import com.lhh.volunteerservicemanagement.entity.ManagerOrder;
import com.lhh.volunteerservicemanagement.service.ManagerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/25 10:34
 * 概要：管理员信息业务逻辑层
 */
@Service
public class ManagerOrderServiceImpl implements ManagerOrderService {

    @Autowired
    ManagerOrderMapper managerOrderMapper;

    @Override
    public PageResult search(Map searchMap) {
        Example example = new Example(ManagerOrder.class);
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
        Page<ManagerOrder> page = (Page<ManagerOrder>) managerOrderMapper.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.MANAGER_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @Override
    @Transactional
    public List searchAll() {
        List<ManagerOrder> managerOrders = managerOrderMapper.selectAll();
        return managerOrders;
    }

    @Override
    @Transactional
    public Boolean add(ManagerOrder managerOrder) {
        managerOrderMapper.insertSelective(managerOrder);
        return true;
    }

    @Override
    @Transactional
    public Boolean update(ManagerOrder managerOrder) {
        managerOrderMapper.updateByPrimaryKeySelective(managerOrder);
        return true;
    }

    @Override
    @Transactional
    public Boolean delete(List<Integer> ids) {
        for(Integer id : ids){
            managerOrderMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    @Transactional
    public ManagerOrder findById(Integer id) {
        ManagerOrder managerOrder = managerOrderMapper.selectByPrimaryKey(id);
        return managerOrder;
    }
}
