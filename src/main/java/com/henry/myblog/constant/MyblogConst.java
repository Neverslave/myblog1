package com.henry.myblog.constant;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量类
 * */
@Component
public class MyblogConst {

    public static Map<String,String> InitConfig = new HashMap<>();
    public static String LOGIN_SESSION_KEY  = "login_user";
    public static  final String User_In_Cookie ="Myblog_Cookie";
    public static String AES_CODE = "0123456789ABCDEFG";



}
