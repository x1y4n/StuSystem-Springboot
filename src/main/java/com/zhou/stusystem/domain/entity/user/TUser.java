package com.zhou.stusystem.domain.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@TableName("t_user")
public class TUser {
    private String tid;
    private String username;
    private String password;

}