package com.alfaday.dao.dos;

import lombok.Data;

@Data
public class UserDO {

    private Long id;
    private String username;
    private String password;
    private String userSex;
    private String nickName;
}
