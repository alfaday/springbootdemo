package com.alfaday.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class UserDO {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String userSex;
    private String nickName;
}
