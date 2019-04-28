package com.henry.myblog.service.serviceImpl;

import com.henry.myblog.mapper.UserMapper;
import com.henry.myblog.model.User;
import com.henry.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
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

    @Override
    // todo
    public int lockUserByID(Integer id) {
        User user = getUser(id);
        //
        return 0;
    }

    @Override
    //todo
    public int unLockUserByID(Integer id) {
        return 0;
    }


    /**
     * 更换密码
    * */
    @Override
    public int changePassword(User user, String password) {
        user.setPassword(password);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    //todo 返回数字表示状态 0--正常 1--冻结 -1登录失败
    public boolean dologin(String username ,String password){
        return getUserByUserName(username).getPassword().equals(password)&&getUserByUserName(username).getStatus()==0 ;
    }
}

