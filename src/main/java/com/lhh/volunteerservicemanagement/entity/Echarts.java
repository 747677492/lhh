package com.lhh.volunteerservicemanagement.entity;

/**
 * @author lhh
 * @date 2021/5/5 17:16
 * 概要：
 */
//@Data
public class Echarts {
    private String name;
    private Integer value;

    public Echarts(String name,Integer value){
        this.name = name;
        this.value = value;
    }
    public Echarts(){

    }
}
