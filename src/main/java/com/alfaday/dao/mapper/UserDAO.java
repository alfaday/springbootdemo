package com.alfaday.dao.mapper;

import com.alfaday.dao.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {

    List<UserDO> getAll();
    UserDO getOne(Long id);
    void insert(UserDO user);
    void update(UserDO user);
    void delete(Long id);
}
