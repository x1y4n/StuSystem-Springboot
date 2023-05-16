package com.zhou.stusystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.stusystem.dao.StuDao;
import com.zhou.stusystem.domain.Student;
import com.zhou.stusystem.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;

public class StuServiceImpl extends ServiceImpl<StuDao, Student> implements StuService {
    @Autowired
    private StuDao stuDao;
}
