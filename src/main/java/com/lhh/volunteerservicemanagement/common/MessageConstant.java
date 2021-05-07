package com.lhh.volunteerservicemanagement.common;

/**
 * @author lhh
 * @date 2021/4/26 11:17
 * 概要：
 */
public class MessageConstant {
    //---------------------------小区（Community）操作消息提示信息---------------------------------------
    public static final String COMMUNITY_SEARCH_SUCCESS="查询列表信息成功！";
    public static final String COMMUNITY_ADD_SUCCESS="新增信息成功！";
    public static final String COMMUNITY_UPDATE_SUCCESS="修改信息成功！";
    public static final String COMMUNITY_DELETE_SUCCESS="删除信息成功！";
    public static final String COMMUNITY_PIC_UPLOAD_SUCCESS="缩略图上传成功！";
    public static final String COMMUNITY_PIC_DEL_SUCCESS = "小区缩略图删除成功！";
    public static final String COMMUNITY_FIND_BY_ID_SUCCESS = "根据主键获取对象成功！";
    public static final String COMMUNITY_UPDATE_STATUS_SUCCESS = "状态信息更新成功！";
    //---------------------------楼栋（Community）操作消息提示信息---------------------------------------
    //---------------------------系统提示信息----------------------------------------------------------
    public static final String SYSTEM_BUSY = "系统繁忙，请求稍后重试！";
    //---------------------------文件上传提示信息-------------------------------------------------------
    public static final String NO_FILE_SELECTED = "未选择上传的文件,请求选择后上传!";
    public static final String NO_WRITE_PERMISSION = "上传目录没有写权限!";
    public static final String INCORRECT_DIRECTORY_NAME = "目录名不正确!";
    public static final String SIZE_EXCEEDS__LIMIT = "上传文件大小超过限制!";
    public static final String FILE_TYPE_ERROR = "文件类型错误，只允许上传JPG/PNG/JPEG/GIF等图片类型的文件!";

    //--------------------------- 团队信息（Team）操作提示信息 --------------------------------------------
    public static final String TEAM_SEARCH_SUCCESS="查询团队列表信息成功！";
    public static final String TEAM_ADD_SUCCESS="新增团队信息成功！";
    public static final String TEAM_UPDATE_SUCCESS="修改团队信息成功！";
    public static final String TEAM_DELETE_SUCCESS="删除团队信息成功！";
    public static final String TEAM_FIND_BY_ID_SUCCESS="根据主键获取团队信息成功！";

    //--------------------------- 志愿者（Volunteer）操作提示信息 -----------------------------------------
    public static final String VOLUNTEER_SEARCH_SUCCESS="志愿者列表信息查询成功！";
    public static final String VOLUNTEER_ADD_SUCCESS="新增志愿者信息成功！";
    public static final String VOLUNTEER_UPDATE_SUCCESS="修改志愿者信息成功！";
    public static final String VOLUNTEER_DELETE_SECCESS="删除团队信息成功！";
    public static final String VOLUNTEER_FIND_BY_ID_SUCCESS="根据主键获取团队信息成功！";

    // -------------------------- 活动（Activity）操作提示信息 ----------------------------
    public static final String ACTIVITY_SEARCH_SUCCESS="活动列表信息查询成功！";
    public static final String ACTIVITY_ADD_SUCCESS="活动列表信息添加成功！";
    public static final String ACTIVITY_UPDATE_SUCCESS="活动列表信息更新成功！";
    public static final String ACTIVITY_DELETE_SUCCESS="活动列表信息删除成功！";
    public static final String ACTIVITY_FIND_BY_ID_SUCCESS="根据主键获取列表信息成功！";
    public static final String ACTIVITY_UPDATE_STATUS_SUCCESS = "状态信息更新成功！";

    // -------------------------- 角色（Role）操作信息 -------------------------------
    public static final String ROLE_SEARCH_SUCCESS="角色信息查询成功！";
    public static final String ROLE_ADD_SUCCESS="角色添加成功！";
    public static final String ROLE_UPDATE_SUCCESS="角色信息更新成功！";
    public static final String ROLE_DELETE_SUCCESS="角色信息删除成功！";
    public static final String ROLE_FIND_BY_ID_SUCCESS="根据主键Id列表信息成功！";

    // -------------------------- 通知(Notice)操作信息 --------------------------------
    public static final String NOTICE_SEARCH_SUCCESS="通知信息查询成功！";
    public static final String NOTICE_ADD_SUCCESS="通知添加成功！";
    public static final String NOTICE_UPDATE_SUCCESS="通知信息更新成功！";
    public static final String NOTICE_DELETE_SUCCESS="通知信息删除成功！";
    public static final String NOTICE_FIND_BY_ID_SUCCESS="根据主键Id列表信息成功！";

    // -------------------------- 反馈留言（FeedBack）操作信息- -------------------
    public static final String FEEDBACK_SEARCH_SUCCESS="留言信息查询成功！";
    public static final String FEEDBACK_ADD_SUCCESS="留言添加成功！";
    public static final String FEEDBACK_UPDATE_SUCCESS="留言信息更新成功！";
    public static final String FEEDBACK_DELETE_SUCCESS="留言信息删除成功！";
    public static final String FEEDBACK_FIND_BY_ID_SUCCESS="根据主键Id列表信息成功！";

    // -------------------------- 招募（Enlists）操作信息 -------------------------
    public static final String ENLISTS_SEARCH_SUCCESS="招募信息查询成功！";
    public static final String ENLISTS_ADD_SUCCESS="招募添加成功！";
    public static final String ENLISTS_UPDATE_SUCCESS="招募信息更新成功！";
    public static final String ENLISTS_DELETE_SUCCESS="招募信息删除成功！";
    public static final String ENLISTS_FIND_BY_ID_SUCCESS="根据主键Id列表信息成功！";

    // --------------------------用户（user）操作信息------------------------------
    public static final String USER_SEARCH_SUCCESS="用户信息查询成功！";
    public static final String USER_ADD_SUCCESS="用户添加成功！";
    public static final String USER_UPDATE_SUCCESS="用户信息更新成功！";
    public static final String USER_DELETE_SUCCESS="用户信息删除成功！";
    public static final String USER_FIND_BY_ID_SUCCESS="根据主键Id列表信息成功！";

    // --------------------------管理员（ManagerOrder）操作信息--------------------------
    public static final String MANAGER_SEARCH_SUCCESS="管理员信息查询成功！";
    public static final String MANAGER_ADD_SUCCESS="管理员添加成功！";
    public static final String MANAGER_UPDATE_SUCCESS="管理员信息更新成功！";
    public static final String MANAGER_DELETE_SUCCESS="管理员信息删除成功！";
    public static final String MANAGER_FIND_BY_ID_SUCCESS="根据主键Id列表信息成功！";

    // --------------------------审核（ShenHe）操作信息--------------------------
    public static final String SHENHE_SEARCH_SUCCESS="审核信息查询成功！";
    public static final String SHENHE_ADD_SUCCESS="审核添加成功！";
    public static final String SHENHE_UPDATE_SUCCESS="审核信息更新成功！";
    public static final String SHENHE_DELETE_SUCCESS="审核信息删除成功！";
    public static final String SHENHE_FIND_BY_ID_SUCCESS="根据主键Id列表信息成功！";

    // --------------------------部门（TeamDepartment）操作信息
    public static final String TEAMDEPARTMENT_SEARCH_SUCCESS="部门信息查询成功！";
    public static final String TEAMDEPARTMENT_ADD_SUCCESS="部门添加成功！";
    public static final String TEAMDEPARTMENT_UPDATE_SUCCESS="部门信息更新成功！";
    public static final String TEAMDEPARTMENT_DELETE_SUCCESS="部门信息删除成功！";
    public static final String TEAMDEPARTMENT_FIND_BY_ID_SUCCESS="根据主键Id列表信息成功！";

    // --------------------------服务类型（ServiceType）操作信息
    public static final String SERVICETYPE_SEARCH_SUCCESS="部门信息查询成功！";
    public static final String SERVICETYPE_ADD_SUCCESS="部门添加成功！";
    public static final String SERVICETYPE_UPDATE_SUCCESS="部门信息更新成功！";
    public static final String SERVICETYPE_DELETE_SUCCESS="部门信息删除成功！";
    public static final String SERVICETYPE_FIND_BY_ID_SUCCESS="根据主键Id列表信息成功！";

    // --------------------------

    // --------------------------

    // --------------------------

    // --------------------------

    // --------------------------

    // --------------------------

    // --------------------------

    // --------------------------
}
