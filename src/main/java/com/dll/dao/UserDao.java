package com.dll.dao;

import lombok.Data;

@Data
public class UserDao {

    private Long id;
    private String userName;
    private String password;
    private String userSex;
    private String nickName;
}
