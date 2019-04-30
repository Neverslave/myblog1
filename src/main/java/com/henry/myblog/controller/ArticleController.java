package com.henry.myblog.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.henry.myblog.model.Article;
import com.henry.myblog.service.serviceImpl.ArticleServiceImpl;
import com.henry.myblog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 文章控制器
 * */
@Controller
@RequestMapping("/admin/article")
public class ArticleController {
    @Autowired
    ArticleServiceImpl articleService;

    /**
     * 文章详情页
     * */
    @RequestMapping("/articleDetail")
    public String  articleDetail(){

        return "/static/templates/admin/article/article-add";
    }


    /***
     * 发布文章
     * */
    @PostMapping("/publish")
    @ResponseBody
    public JsonResult articlePublish(HttpServletRequest request, @RequestBody Article article){
        String uuid = IdUtil.simpleUUID();
        article.setUuid(uuid);
        article.setCreateTime(DateUtil.now());
        articleService.AddArticle(article);
        return JsonResult.ok(article);
    }

/**
 * 获取文章列表
 * */
    @RequestMapping("/getArticleList")
    @ResponseBody
    public JsonResult getArticleList(Integer page){
    /**
     * 使用 ModelAndView只能使用jsp thymeleaf 等后端渲染的模板语言
     *  ModelAndView mv = new ModelAndView();
        mv.addObject("articleList","string111");
        mv.setViewName("/static/templates/admin/article/admin-list");//设置页面地址
        return mv;
     */
    if(page ==null){
        page =1;
    }
    List<Article> list = articleService.queryUserListPaged(page,20);
        return JsonResult.ok(list);
    }

    /**
     * 删除文章
     * */
    @RequestMapping("/deleteArticle")
    @ResponseBody
    public JsonResult deleteArticle(@RequestBody  Article article){
       if(articleService.deleteArticle(article) ==0){
           return JsonResult.ok();
       }
      return  JsonResult.errorMsg("删除失败");
    }
    


}
