package com.henry.myblog.model;

import javax.persistence.*;

public class Article {
    @Id
    private String uuid;

    private String title;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;

    private String catalog;

    /**
     * 文章状态 0发布 1草稿 2删除
     */
    private Integer status;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 摘要
     */
    private String summary;

    /**
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return create_time
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return catalog
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * @param catalog
     */
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    /**
     * 获取文章状态 0发布 1草稿 2删除
     *
     * @return status - 文章状态 0发布 1草稿 2删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置文章状态 0发布 1草稿 2删除
     *
     * @param status 文章状态 0发布 1草稿 2删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取文章内容
     *
     * @return content - 文章内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置文章内容
     *
     * @param content 文章内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取摘要
     *
     * @return summary - 摘要
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置摘要
     *
     * @param summary 摘要
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }
}