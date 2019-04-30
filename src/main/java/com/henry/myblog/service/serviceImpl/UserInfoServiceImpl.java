package com.henry.myblog.service.serviceImpl;

import com.henry.myblog.mapper.UserInfoMapper;
import com.henry.myblog.model.UserInfo;
import com.henry.myblog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public UserInfo getUserInfo(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
