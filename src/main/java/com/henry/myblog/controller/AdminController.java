package com.henry.myblog.controller;

import com.henry.myblog.model.Log;
import com.henry.myblog.model.User;
import com.henry.myblog.service.serviceImpl.LogServiceImpl;
import com.henry.myblog.service.serviceImpl.UserServiceImpl;
import com.henry.myblog.util.IpUtil;
import com.henry.myblog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台登录
 *
 * @author zhu
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    LogServiceImpl logService;

    /**
     * 登录页
     */
    @RequestMapping("/login")
    public String login() {
        return "/static/templates/admin/login";
    }


    /**
     * 登录校验
     */
    @PostMapping(value = "/doLogin")
    @ResponseBody
    public JsonResult doLogin(@RequestParam String username,
                              @RequestParam String password,
                              HttpServletRequest request, HttpServletResponse response) {
        User user = userService.getUserByUserName(username);
        if (user == null) {
            return JsonResult.errorException("登录失败");
        }
        if (!userService.dologin(username, password)) {
            return JsonResult.errorException("密码错误");
        }
        //todo log ip and time remember satus
        String ip = IpUtil.getRealIp(request);
        //写入log
        Log log = logService.createLog(ip, user);
        logService.insertLog(log);
        return JsonResult.ok("登录成功");
    }

    @RequestMapping("/index")
    public String getAdminIndex() {
        return "/static/templates/admin/index";
    }

    @RequestMapping("/user")
    public String getAdminUser() {

        return "/static/templates/admin/admin-user";
    }

    @RequestMapping("/form")
    public String getAdminForm() {

        return "/static/templates/admin/admin-form";
    }
    @RequestMapping("/table")
    public String getAdminTable() {

        return "/static/templates/admin/admin-table";
    }
    @RequestMapping("/help")
    public String getAdminHelp() {

        return "/static/templates/admin/admin-help";
    }

    @RequestMapping("/gallery")
    public String getAdminGallery() {

        return "/static/templates/admin/admin-gallery";
    }

    @RequestMapping("/log")
    public String getAdminLog() {

        return "/static/templates/admin/admin-log";
    }


    @RequestMapping("/404")
    public String getAdmin404() {

        return "/static/templates/admin/admin-404";
    }


}
