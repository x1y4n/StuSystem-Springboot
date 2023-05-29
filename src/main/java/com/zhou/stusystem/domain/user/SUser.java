package com.zhou.stusystem.domain.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@TableName("s_user")
public class SUser {
    private String sid;
    private String username;
    private String password;

}