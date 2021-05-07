package com.lhh.volunteerservicemanagement.dao;

import com.lhh.volunteerservicemanagement.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserMapper extends Mapper<User> {

//    int deleteByPrimaryKey(Integer id);
//
//    int insert(User record);
//
//    int insertSelective(User record);
//
//    User selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);

    List<User> getAllUser();

    @Select("select username,id from user where username=#{username}")
    User getAllUserByName(@Param("username") String username);

    @Select("    SELECT username FROM tb_user where username=#{username} and password=#{password}")
    User loginPage(@Param("username")String username,@Param("password")String password);

    List<User> getUserByUsernameAndPass(@Param("username") String username,@Param("pass") String pass);

    // 登录
    public User login(@Param("username") String username,@Param("userpassword") String userpassword);
}