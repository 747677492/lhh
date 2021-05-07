package com.lhh.volunteerservicemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lhh.volunteerservicemanagement.common.MessageConstant;
import com.lhh.volunteerservicemanagement.common.PageResult;
import com.lhh.volunteerservicemanagement.common.StatusCode;
import com.lhh.volunteerservicemanagement.dao.VolunteerOrderMapper;
import com.lhh.volunteerservicemanagement.entity.VolunteerOrder;
import com.lhh.volunteerservicemanagement.service.VolunteerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/4/25 10:37
 * 概要：
 */
@Service
public class VolunteerOrderServiceImpl implements VolunteerOrderService {

    @Autowired
    private VolunteerOrderMapper volunteerOrderMapper;

    @Override
    public PageResult search(Map searchMap) {
        //指定查询的表
        Example example = new Example(VolunteerOrder.class);
        int pageNum = 1;//设置默认值
        int pageSize = 2;
        if(searchMap != null) {
            //查询条件
            Example.Criteria criteria = example.createCriteria();
            //添加条件
            String name = (String) searchMap.get("name");
            //模糊查询去除前后空格
            if (StringUtil.isNotEmpty(name)) {
                criteria.andLike("name", "%" + name.trim() + "%");
            }
            String startTime = (String) searchMap.get("startTime");
            if (StringUtil.isNotEmpty(startTime)) {
                //大于开始时间
                criteria.andGreaterThanOrEqualTo("createTime", startTime);
            }
            String endTime = (String) searchMap.get("endTime");
            if (StringUtil.isNotEmpty(endTime)) {
                //小于结束时间
                criteria.andLessThanOrEqualTo("createTime", endTime);
            }
            if ((Integer) searchMap.get("pageNum") != null) {
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if ((Integer) searchMap.get("pageSize") != null) {
                pageSize = (Integer) searchMap.get("pageSize");
            }
            //特别注意：该行代码后面要紧跟要执行的查询语句 对页码进行拼接
            PageHelper.startPage(pageNum, pageSize);
        }
        Page<VolunteerOrder> page = (Page<VolunteerOrder>) volunteerOrderMapper.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.VOLUNTEER_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @Override
    @Transactional
    public Boolean add(VolunteerOrder volunteerOrder) {
        volunteerOrderMapper.insertSelective(volunteerOrder);
        return true;
    }

    @Override
    @Transactional
    public List searchAll() {
        List<VolunteerOrder> volunteerOrders = volunteerOrderMapper.selectAll();
        return volunteerOrders;
    }

    @Override
    @Transactional
    public VolunteerOrder findByID(Integer id) {
        VolunteerOrder volunteerOrder = volunteerOrderMapper.selectByPrimaryKey(id);
        return volunteerOrder;
    }

    @Override
    @Transactional
    public Boolean update(VolunteerOrder volunteerOrder) {
        volunteerOrderMapper.updateByPrimaryKeySelective(volunteerOrder);
        return true;
    }

    @Override
    @Transactional
    public Boolean delete(List<Integer> ids) {
        for (Integer id:ids){
            volunteerOrderMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
