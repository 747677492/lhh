package com.lhh.volunteerservicemanagement.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author lhh
 * @date 2021/5/5 17:00
 * 概要：
 */
public class ShiroMD5Privacy {
    public static String privacy(String loginname,String password) {
        //对明文密码进行加密
        String  algorithmName = "MD5";
        Object  source = password;
        Object  salt = ByteSource.Util.bytes(loginname);
        int     hashIterations = 1024; //加密1024次
        Object  privacy = new SimpleHash(algorithmName, source,salt,hashIterations);
        String  privacypassword = privacy.toString();
        return privacypassword;
    }

    public static void main(String[] args) {
        String a = privacy("ahualy","a123456");
        System.out.println(a);
    }
}
