package com.henry.myblog.mapper;

import com.henry.myblog.model.User;
import com.henry.myblog.util.MyMapper;

public interface UserMapper extends MyMapper<User> {
   User selectByUsername(String username);
}