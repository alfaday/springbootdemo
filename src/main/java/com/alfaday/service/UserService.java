package com.alfaday.service;

import com.alfaday.dao.model.UserDO;
import com.alfaday.dao.mapper.UserDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Data
@Service
public class UserService {


    @Autowired
    private UserDAO userDAO;

    @Transactional
    public String getUser(long id){
        UserDO one = userDAO.getOne(id);
        if(one != null){
            return one.getUsername();
        }
        return "no-user!";
    }

    @Transactional(isolation= Isolation.REPEATABLE_READ,readOnly = false,rollbackFor = Exception.class)
    public int insertUser(UserDO userDO){
        return userDAO.insert(userDO);
    }

    @Transactional(isolation= Isolation.REPEATABLE_READ,readOnly = false,rollbackFor = Exception.class)
    public int deleteById(Long id){
        return userDAO.deleteById(id);
    }

    @Transactional(isolation= Isolation.REPEATABLE_READ,readOnly = false,rollbackFor = Exception.class)
    public int updateUser(UserDO userDO){
        return userDAO.updateById(userDO);
    }
}
