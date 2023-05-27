package com.gupt.bigdata.sparkmoviesweb.service;


import com.gupt.bigdata.sparkmoviesweb.entity.User;
import com.gupt.bigdata.sparkmoviesweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public List<User> getUserList(){
        return userMapper.getUserList();
    };

    public User getUserById(int userid){
        return userMapper.getUserById(userid);
    };

    public List<User> getUsersByName(String username){
        return userMapper.getUsersByName(username);
    };

    public int insertUser(User user){
        return userMapper.insertUser(user);
    };

    public int deleteUserById(int userid){
        return userMapper.deleteUserById(userid);
    };

    public int updatePasswordById(User user){
        return userMapper.updatePasswordById(user);
    };

    public User loginUser(User user){
        return userMapper.loginUser(user);
    }
}
