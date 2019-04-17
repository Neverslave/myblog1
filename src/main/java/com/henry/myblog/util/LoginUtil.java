package com.henry.myblog.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.henry.myblog.constant.MyblogConst;
import com.henry.myblog.model.User;
import com.henry.myblog.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginUtil {
    @Autowired
    UserServiceImpl userService;



    /**
     * 设置记住密码cookie
     *
     * @param response
     * @param uid
     */
    public static void setCookie(HttpServletResponse response, Integer uid) {
        try {
            AES aes = SecureUtil.aes(MyblogConst.AES_CODE.getBytes());
            String val = aes.encryptHex(uid.toString());
            boolean isSSL = false;
            Cookie cookie = new Cookie(MyblogConst.User_In_Cookie, val);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 12);
            cookie.setSecure(isSSL);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        /**
         * 通过Session 获取当前用户
         *
         * */
    public static User getUserBySession(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(null==session){
            return null;
        }
        return (User)session.getAttribute(MyblogConst.LOGIN_SESSION_KEY);
    }

    /**
     * 通过Cookie 获取当前用户
     * */
    public User getUserByCookie(HttpServletRequest request){
        AES aes = SecureUtil.aes(MyblogConst.AES_CODE.getBytes());
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(MyblogConst.User_In_Cookie)){
                Integer uid =Integer.valueOf(aes.decryptStr(cookie.getValue(), CharsetUtil.CHARSET_UTF_8));
                return userService.getUser(uid);
            }
        }
        return  null;
    }
    /***
     * 登陆后设置Session
     *
     * */
        public static void setSession(HttpServletRequest request,User user){
           HttpSession session = request.getSession();
           session.setAttribute(MyblogConst.LOGIN_SESSION_KEY,user);
        }
}
