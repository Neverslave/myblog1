package com.henry.myblog.controller;

import com.henry.myblog.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 后台登录
 * @author zhu
 *
 * */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    /**
    * 登录页
    * */
    @GetMapping(value = "/login")
    public String login(){
        return  "templates/admin/login.html";
    }


}
