package com.zhou.stusystem.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.stusystem.dao.user.SUserDao;
import com.zhou.stusystem.domain.entity.user.SUser;
import com.zhou.stusystem.service.user.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SUserServiceImpl extends ServiceImpl<SUserDao, SUser> implements SUserService {
    @Autowired
    private SUserDao sUserDao;
}
