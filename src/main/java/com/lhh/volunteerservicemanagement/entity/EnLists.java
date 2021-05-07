package com.lhh.volunteerservicemanagement.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table(name = "tb_enlists")
public class EnLists implements Serializable {

    @Id
    private Integer id;
    private String treason;
    private Date date;
    private Integer activityId;
    private String volunteerName;
    private String activityName;
    private String shenheStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getTreason() {
        return treason;
    }

    public void setTreason(String treason) {
        this.treason = treason;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getShenheStatus() {
        return shenheStatus;
    }

    public void setShenheStatus(String shenheStatus) {
        this.shenheStatus = shenheStatus;
    }
}