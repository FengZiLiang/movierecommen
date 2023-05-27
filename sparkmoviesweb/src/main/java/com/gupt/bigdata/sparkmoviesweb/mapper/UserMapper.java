package com.gupt.bigdata.sparkmoviesweb.mapper;

import com.gupt.bigdata.sparkmoviesweb.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User>  getUserList();

    public User getUserById(int userid);

    public List<User> getUsersByName(String username);

    public int insertUser(User user);

    public int deleteUserById(int userid);

    public int updatePasswordById(User user);

    public User loginUser(User user);
}
