package com.zhou.stusystem.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.stusystem.dao.user.TUserDao;
import com.zhou.stusystem.domain.entity.user.TUser;
import com.zhou.stusystem.service.user.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TUserServiceImpl extends ServiceImpl<TUserDao, TUser> implements TUserService {
    @Autowired
    private TUserDao tUserDao;
}
