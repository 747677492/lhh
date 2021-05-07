package com.lhh.volunteerservicemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.dao.ActivityMapper;
import com.lhh.volunteerservicemanagement.entity.Activity;
import com.lhh.volunteerservicemanagement.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/25 10:33
 * 概要：
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public PageResult search(Map searchMap) {
        Example example = new Example(Activity.class);
        int pageNum = 1;//默认值
        int pageSize = 2;
        if(searchMap != null) {
            //指定查询的表
            //查询条件
            Example.Criteria criteria = example.createCriteria();
            //添加条件
            String name = (String)searchMap.get("teamName");
            System.out.println("========================================");
            System.out.println(name);
            if(StringUtil.isNotEmpty(name)){
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
            //特别注意：该行代码后面要紧跟要执行的查询语句
            PageHelper.startPage(pageNum,pageSize);
        }
        Page<Activity> page = (Page<Activity>) activityMapper.selectByExample(example);
        System.out.println(page.getResult());
        return new PageResult(true, StatusCode.OK, MessageConstant.ACTIVITY_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    // 添加
    @Override
    @Transactional
    public Boolean add(Activity activity) {
        activityMapper.insertSelective(activity);
        return true;
    }

    // 查询所有
    @Override
    @Transactional
    public List searchAll() {
        List<Activity> activities = activityMapper.selectAll();
        return activities;
    }

    // 根据主键Id查询
    @Override
    public Activity findById(Integer id) {
        Activity activity = activityMapper.selectByPrimaryKey(id);
        return activity;
    }

    @Override
    @Transactional
    public Boolean update(Activity activity) {
        activityMapper.updateByPrimaryKeySelective(activity);
        return true;
    }

    @Override
    @Transactional
    public Boolean delete(List<Integer> ids) {
        for (Integer id : ids){
            activityMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean upStatus(String status, Integer id) {
        Activity activity = new Activity();
        activity.setId(id);
        activity.setStatus(status);
        activityMapper.updateByPrimaryKeySelective(activity);
        return true;
    }

    @Override
    @Transactional
    public Boolean update1(Activity activity) {
        activityMapper.updateByPrimaryKey(activity);
        return true;
    }
}
