package com.alfaday.dao.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class UserDO {

    private Long id;
    private String username;
    private String password;
    private String userSex;
    private String nickName;
}
