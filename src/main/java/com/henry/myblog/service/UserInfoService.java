package com.henry.myblog.service;

import com.henry.myblog.model.UserInfo;

public interface UserInfoService {
    public int updateUserInfo(UserInfo userInfo);
    public UserInfo getUserInfo(Integer id);
    
}
