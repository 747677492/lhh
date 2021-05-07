package com.lhh.volunteerservicemanagement.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_shenhe")
public class ShenHe {

    @Id
    private Integer id;
    private String name;
    private String descp;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp == null ? null : descp.trim();
    }
}