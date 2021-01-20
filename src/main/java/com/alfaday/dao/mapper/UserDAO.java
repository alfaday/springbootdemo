package com.alfaday.dao.mapper;

import com.alfaday.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {

    List<UserDao> getAll();
    UserDao getOne(Long id);
    void insert(UserDao user);
    void update(UserDao user);
    void delete(Long id);
}
