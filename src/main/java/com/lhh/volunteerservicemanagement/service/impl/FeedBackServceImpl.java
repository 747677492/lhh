package com.lhh.volunteerservicemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.dao.FeedBackMapper;
import com.lhh.volunteerservicemanagement.entity.FeedBack;
import com.lhh.volunteerservicemanagement.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/29 11:22
 * 概要：
 */
@Service
public class FeedBackServceImpl implements FeedBackService {

    @Autowired
    private FeedBackMapper feedBackMapper;

    @Override
    public PageResult search(Map searchMap) {
        Example example = new Example(FeedBack.class);
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
        Page<FeedBack> page = (Page<FeedBack>) feedBackMapper.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.FEEDBACK_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @Override
    @Transactional
    public Boolean add(FeedBack feedBack) {
        feedBackMapper.insertSelective(feedBack);
        return true;
    }

    @Override
    @Transactional
    public List searchAll() {
        List<FeedBack> feedBacks = feedBackMapper.selectAll();
        return feedBacks;
    }

    @Override
    @Transactional
    public FeedBack findById(Integer id) {
        FeedBack feedBack = feedBackMapper.selectByPrimaryKey(id);
        return feedBack;
    }

    @Override
    @Transactional
    public Boolean update(FeedBack feedBack) {
        feedBackMapper.updateByPrimaryKeySelective(feedBack);
        return true;
    }

    @Override
    @Transactional
    public Boolean delete(List<Integer> ids) {
        for (Integer id : ids){
            feedBackMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
