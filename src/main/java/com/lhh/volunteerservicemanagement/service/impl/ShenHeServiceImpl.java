package com.lhh.volunteerservicemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.dao.ShenHeMapper;
import com.lhh.volunteerservicemanagement.dao.TeamDepartmentMapper;
import com.lhh.volunteerservicemanagement.entity.ShenHe;
import com.lhh.volunteerservicemanagement.service.ShenHeService;
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
public class ShenHeServiceImpl implements ShenHeService {

    @Autowired
    private ShenHeMapper shenHeMapper;

    @Override
    public PageResult search(Map searchMap) {
        Example example = new Example(ShenHe.class);
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
        Page<ShenHe> page = (Page<ShenHe>) shenHeMapper.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.SHENHE_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @Override
    @Transactional
    public Boolean add(ShenHe shenHe) {
        shenHeMapper.insertSelective(shenHe);
        return true;
    }

    @Override
    @Transactional
    public List searchAll() {
        List<ShenHe> shenHes = shenHeMapper.selectAll();
        return shenHes;
    }

    @Override
    @Transactional
    public ShenHe findById(Integer id) {
        ShenHe shenHe = shenHeMapper.selectByPrimaryKey(id);
        return shenHe;
    }

    @Override
    @Transactional
    public Boolean update(ShenHe shenHe) {
        shenHeMapper.updateByPrimaryKeySelective(shenHe);
        return true;
    }

    @Override
    public Boolean delete(List<Integer> ids) {
        for (Integer id : ids){
            shenHeMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
