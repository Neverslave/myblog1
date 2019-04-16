package com.henry.myblog.service.serviceImpl;

import com.henry.myblog.mapper.UserMapper;
import com.henry.myblog.model.User;
import com.henry.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUser(Integer id) {
       return userMapper.selectByPrimaryKey(id) ;

    }

    @Override
    public int deleteUser(Integer id) {
       return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user); //只更新 有的字段
    }

    @Override
    public User getUserByUserName(String username) {
        return userMapper.selectByUsername(username);
    }
}
