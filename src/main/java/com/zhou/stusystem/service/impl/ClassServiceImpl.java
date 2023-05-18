package com.zhou.stusystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.stusystem.dao.ClassDao;
import com.zhou.stusystem.domain.Class;
import com.zhou.stusystem.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl extends ServiceImpl<ClassDao, Class> implements ClassService {
    @Autowired
    ClassDao classDao;
}
