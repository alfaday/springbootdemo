package com.alfaday.service;

import com.alfaday.dao.UserDao;
import com.alfaday.dao.mapper.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserDAO userDAO;

    public String getUser(long id){
        UserDao one = userDAO.getOne(id);
        if(one != null){
            return one.getUserName();
        }
        return "no-user!";
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
