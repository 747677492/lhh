package com.lhh.volunteerservicemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.dao.TeamOrderMapper;
import com.lhh.volunteerservicemanagement.entity.ManagerOrder;
import com.lhh.volunteerservicemanagement.entity.TeamOrder;
import com.lhh.volunteerservicemanagement.service.TeamOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/25 10:36
 * 概要：
 */
@Service
public class TeamOrderServiceImpl implements TeamOrderService {

    @Autowired
    private TeamOrderMapper teamOrderMapper;

    @Override
    public PageResult search(Map searchMap) {
        Example example = new Example(TeamOrder.class);
        int pageNum = 1;    //默认值
        int pageSize = 2;
        if(searchMap != null){
            //指定查询条件表
            //查询条件
            Example.Criteria criteria = example.createCriteria();
            //添加条件
            String name = (String)searchMap.get("teamName");
            System.out.println("===============");
            System.out.println(name);
            if (StringUtil.isNotEmpty(name)){
                criteria.andLike("teamName","%"+name.trim()+"%");
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
            //特别注意：该行代码后面要紧跟执行的查询语句
            PageHelper.startPage(pageNum,pageSize);
        }

        Page<TeamOrder> page = (Page<TeamOrder>) teamOrderMapper.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.TEAM_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @Override
    @Transactional
    public Boolean add(TeamOrder teamOrder) {
        teamOrderMapper.insertSelective(teamOrder);
        return true;
    }

    @Override
    @Transactional
    public List searchAll() {
        List<TeamOrder> teamOrders = teamOrderMapper.selectAll();
        return teamOrders;
    }

    @Override
    @Transactional
    public TeamOrder findById(Integer id) {
        TeamOrder teamOrder = teamOrderMapper.selectByPrimaryKey(id);
        return teamOrder;
    }

    @Override
    @Transactional
    public Boolean update(TeamOrder teamOrder) {
        teamOrderMapper.updateByPrimaryKeySelective(teamOrder);
        return true;
    }

    @Override
    @Transactional
    public Boolean delete(List<Integer> ids) {
        for (Integer id : ids){
            teamOrderMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
