package com.zhou.stusystem.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.stusystem.dao.user.SUserDao;
import com.zhou.stusystem.dao.user.TUserDao;
import com.zhou.stusystem.domain.user.SUser;
import com.zhou.stusystem.domain.user.TUser;
import com.zhou.stusystem.service.user.SUserService;
import com.zhou.stusystem.service.user.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SUserServiceImpl extends ServiceImpl<SUserDao, SUser> implements SUserService {
    @Autowired
    private SUserDao sUserDao;
}
