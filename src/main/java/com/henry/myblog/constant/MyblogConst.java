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


}
