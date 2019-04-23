package com.henry.myblog.service.serviceImpl;

import com.henry.myblog.mapper.ArticleMapper;
import com.henry.myblog.model.Article;
import com.henry.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public int AddArticle(Article article) {
        return articleMapper.insert(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public int deleteArticle(Article article) {
        article.setStatus(2);
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public Article queryArticleById(String uuid) {
        return articleMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public List<Article> queryArticleListByStatus(int status) {
        return null;
    }
}
