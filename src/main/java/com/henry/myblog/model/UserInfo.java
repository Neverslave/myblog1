package com.henry.myblog.model;

import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    /**
     * uid 与user表关联
     */
    @Id
    private Integer uid;

    /**
     * 姓名
     */
    private String name;

    private String birthday;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 简介
     */
    private String intro;

    /**
     * 获取uid 与user表关联
     *
     * @return uid - uid 与user表关联
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置uid 与user表关联
     *
     * @param uid uid 与user表关联
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取邮箱
     *
     * @return mail - 邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置邮箱
     *
     * @param mail 邮箱
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 获取简介
     *
     * @return intro - 简介
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置简介
     *
     * @param intro 简介
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }
}