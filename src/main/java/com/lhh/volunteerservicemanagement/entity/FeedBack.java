package com.lhh.volunteerservicemanagement.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tb_feedback")
public class FeedBack implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback.id
     *
     * @mbg.generated
     */
    @Id
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback.activity_name
     *
     * @mbg.generated
     */
    private String activityName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback.feedback_content
     *
     * @mbg.generated
     */
    private String feedbackContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback.date
     *
     * @mbg.generated
     */
    private Date date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback.reply
     *
     * @mbg.generated
     */
    private String reply;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback.reply_date
     *
     * @mbg.generated
     */
    private Date replyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback.volunteer_id
     *
     * @mbg.generated
     */
    private Integer volunteerId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback.id
     *
     * @return the value of tb_feedback.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback.id
     *
     * @param id the value for tb_feedback.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback.activity_name
     *
     * @return the value of tb_feedback.activity_name
     *
     * @mbg.generated
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback.activity_name
     *
     * @param activityName the value for tb_feedback.activity_name
     *
     * @mbg.generated
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback.feedback_content
     *
     * @return the value of tb_feedback.feedback_content
     *
     * @mbg.generated
     */
    public String getFeedbackContent() {
        return feedbackContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback.feedback_content
     *
     * @param feedbackContent the value for tb_feedback.feedback_content
     *
     * @mbg.generated
     */
    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent == null ? null : feedbackContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback.date
     *
     * @return the value of tb_feedback.date
     *
     * @mbg.generated
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback.date
     *
     * @param date the value for tb_feedback.date
     *
     * @mbg.generated
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback.reply
     *
     * @return the value of tb_feedback.reply
     *
     * @mbg.generated
     */
    public String getReply() {
        return reply;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback.reply
     *
     * @param reply the value for tb_feedback.reply
     *
     * @mbg.generated
     */
    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback.reply_date
     *
     * @return the value of tb_feedback.reply_date
     *
     * @mbg.generated
     */
    public Date getReplyDate() {
        return replyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback.reply_date
     *
     * @param replyDate the value for tb_feedback.reply_date
     *
     * @mbg.generated
     */
    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback.volunteer_id
     *
     * @return the value of tb_feedback.volunteer_id
     *
     * @mbg.generated
     */
    public Integer getVolunteerId() {
        return volunteerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback.volunteer_id
     *
     * @param volunteerId the value for tb_feedback.volunteer_id
     *
     * @mbg.generated
     */
    public void setVolunteerId(Integer volunteerId) {
        this.volunteerId = volunteerId;
    }
}