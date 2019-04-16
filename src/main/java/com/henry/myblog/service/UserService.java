package com.henry.myblog.service;

import com.henry.myblog.model.User;


public interface UserService {

    public User  getUser(Integer id);
    public int deleteUser(Integer id);
    public int updateUser(User user);
    public User  getUserByUserName(String username);


}
