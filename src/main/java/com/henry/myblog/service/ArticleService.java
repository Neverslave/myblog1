package com.henry.myblog.service;

import com.henry.myblog.model.Article;

import java.util.List;

public interface ArticleService {
    int AddArticle(Article article);
    int updateArticle(Article article);
    int deleteArticle(Article article);
    Article queryArticleById(String uuid);
    public List<Article> queryUserListPaged( Integer page, Integer pageSize);

}
