package com.henry.myblog.controller;

import cn.hutool.cache.Cache;
import com.henry.myblog.model.User;
import com.henry.myblog.service.UserService;
import com.henry.myblog.service.serviceImpl.UserServiceImpl;
import com.henry.myblog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台登录
 * @author zhu
 *
 * */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Autowired
    UserServiceImpl userService;
    /**
    * 登录页
    * */
    @RequestMapping("/login")
    public String login(){
        return "/static/templates/admin/login";
    }


    /**
     * 登录校验
     * */
    @PostMapping(value = "/doLogin")
    @ResponseBody
    public JsonResult doLogin(@RequestParam String username,
                              @RequestParam String password,
                              HttpServletRequest request, HttpServletResponse response){
        User user =userService.getUserByUserName(username);
        if(user == null){
            return JsonResult.errorException("登录失败");
        }
        if(!userService.dologin(username,password)){
            return JsonResult.errorException("密码错误");
        }
        //todo log ip and time remember satus

        return JsonResult.ok("登录成功");
    }

    @RequestMapping("/index")
    public String getAdminIndex(){
        return "/static/templates/admin/index";
    }

    @RequestMapping("/user")
    public String getAdminUser(){

        return "/static/templates/admin/admin-user";
    }
    @RequestMapping("/help")
    public String getAdminHelp(){

        return "/static/templates/admin/admin-help";
    }

    @RequestMapping("/gallery")
    public String getAdminGallery(){

        return "/static/templates/admin/admin-gallery";
    }
    @RequestMapping("/log")
    public String getAdminLog(){

        return "/static/templates/admin/admin-log";
    }


    @RequestMapping("/404")
    public String getAdmin404(){

        return "/static/templates/admin/admin-404";
    }



}
