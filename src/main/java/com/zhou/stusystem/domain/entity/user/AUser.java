package com.zhou.stusystem.domain.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@TableName("a_user")
public class AUser {
    private String id;
    private String username;
    private String password;

}