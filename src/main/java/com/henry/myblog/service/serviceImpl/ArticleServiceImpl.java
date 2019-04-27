package com.henry.myblog.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.henry.myblog.mapper.ArticleMapper;
import com.henry.myblog.model.Article;
import com.henry.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
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
    /***
     * 分页查询文章
     *
     * */
    @Override
    public List<Article> queryUserListPaged(Integer page, Integer pageSize) {
        //开始分页
        PageHelper.startPage(page,pageSize);
        //    使用createria
        Example example =new Example(Article.class);
        Example.Criteria criteria = example.createCriteria();
        example.orderBy("createTime").desc();
        List<Article> list  =new ArrayList();
        return list= articleMapper.selectByExample(example);

    }
}


