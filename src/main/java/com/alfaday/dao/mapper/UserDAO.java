package com.alfaday.dao.mapper;

import com.alfaday.dao.model.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends BaseMapper<UserDO> {

    List<UserDO> getAll();
    UserDO getOne(Long id);
//    void insert(UserDO user);
//    void update(UserDO user);
//    void delete(Long id);
}
