package com.alfaday.dao;

import lombok.Data;

@Data
public class UserDO {

    private Long id;
    private String userName;
    private String password;
    private String userSex;
    private String nickName;
}
