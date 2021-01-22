package com.alfaday.service;

import com.alfaday.dao.model.UserDO;
import com.alfaday.dao.mapper.UserDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Transactional
    public void insertUser(UserDO userDO){
        userDAO.insert(userDO);
    }

}
