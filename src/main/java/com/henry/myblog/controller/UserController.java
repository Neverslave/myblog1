package com.henry.myblog.controller;

import com.henry.myblog.model.User;
import com.henry.myblog.model.UserInfo;
import com.henry.myblog.service.serviceImpl.UserInfoServiceImpl;
import com.henry.myblog.service.serviceImpl.UserServiceImpl;
import com.henry.myblog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserInfoServiceImpl userInfoService;
        /**
         *人员信息 userInfo
        **/
    @RequestMapping("/userInfo")
    @ResponseBody
    public JsonResult userInfo(Integer id){
     UserInfo userInfo= userInfoService.getUserInfo(id);
     return JsonResult.ok(userInfo);
    }

    /**
     * 更改密码
     * */
    @PostMapping("/changePassword")
    @ResponseBody
    public JsonResult changePassword(Integer id ,String password){
        User user= userService.getUser(id);
        //todo 密码加盐
        if(userService.changePassword(user,password) ==0) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.errorMsg("修改失败");
    }

    /***
     * 更新人员信息
     * */
    @PostMapping("/updateUserInfo")
    @ResponseBody
    public JsonResult updateUserInfo(@RequestBody UserInfo userInfo){
        //todo 需要先在userinfo表写入 否则update无效
        //前台要JSON.Stringify(Json) 后台若使用@RequestBody
        userInfo.setUid(1);
        userInfoService.updateUserInfo(userInfo);
        return JsonResult.ok("更新成功");
    }

}
