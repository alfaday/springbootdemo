package com.dll.service;

import com.dll.dao.UserDao;
import com.dll.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public String getUser(long id){
        UserDao one = userMapper.getOne(id);
        if(one != null){
            return one.getUserName();
        }
        return "no-user!";
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
