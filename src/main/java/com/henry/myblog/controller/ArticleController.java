package com.henry.myblog.controller;

import com.henry.myblog.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 文章控制器
 * */
@Controller
@RequestMapping("/admin/article")
public class ArticleController {

    /**
     * 文章详情页
     * */
    @RequestMapping("/articleDetail")
    public String  articleDetail(){

        return "/static/templates/admin/article/article-add";
    }


    @PostMapping("/publish")
    @ResponseBody
    public JsonResult articlePublish(HttpServletRequest request){
        request.getAttribute("content");
        return JsonResult.ok(request.getAttribute("content"));

    }
}
