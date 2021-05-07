package com.lhh.volunteerservicemanagement.utils;

import java.util.HashMap;

/**
 * @author lhh
 * @date 2021/5/5 17:03
 * 概要：
 */
public class SessionSave {
    private static HashMap<String, String> SessionIdSave = new HashMap<String,String>();

    public static HashMap<String, String> getSessionIdSave() {
        return SessionIdSave;
    }

    public static void setSessionIdSave(HashMap<String, String> sessionIdSave) {
        SessionIdSave = sessionIdSave;
    }
}
