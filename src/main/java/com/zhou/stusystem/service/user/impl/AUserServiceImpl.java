package com.zhou.stusystem.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.stusystem.dao.user.AUserDao;
import com.zhou.stusystem.domain.entity.user.AUser;
import com.zhou.stusystem.service.user.AUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AUserServiceImpl extends ServiceImpl<AUserDao, AUser> implements AUserService {
    @Autowired
    private AUserDao aUserDao;
}
