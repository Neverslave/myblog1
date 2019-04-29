package com.henry.myblog.controller;

import com.henry.myblog.model.User;
import com.henry.myblog.service.serviceImpl.UserServiceImpl;
import com.henry.myblog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
        /**
         *人员信息
        **/
    @RequestMapping("/userInfo")
    @ResponseBody
    public JsonResult userInfo(Integer id){
     User user= userService.getUser(id);
     return JsonResult.ok(user);
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
    @PostMapping("/updateUser")
    @ResponseBody
    public JsonResult updateUser(User user){
        userService.updateUser(user);
        return JsonResult.ok("更新成功");
    }

}
