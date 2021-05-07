package com.lhh.volunteerservicemanagement.utils;

import java.text.SimpleDateFormat;

/**
 * @author lhh
 * @date 2021/5/5 16:59
 * 概要：
 */
public class RandomCode {
    public static String getRandomCode(){
        SimpleDateFormat tempDate = new SimpleDateFormat("yyMMddHHmmss");
        String random = tempDate.format(new java.util.Date());
        return random;
    }
}
