package com.zhou.stusystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.stusystem.dao.StuDao;
import com.zhou.stusystem.domain.Class;
import com.zhou.stusystem.domain.Courses;
import com.zhou.stusystem.domain.Scores;
import com.zhou.stusystem.domain.Students;
import com.zhou.stusystem.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StuServiceImpl extends ServiceImpl<StuDao, Students> implements StuService {
    @Autowired
    private StuDao stuDao;

    @Override
    public Class getClass(String sid) {
        return stuDao.getClassBySid(sid);
    }

    @Override
    public ArrayList<Courses> getCourse(String sid) {
        return stuDao.getCourseBySid(sid);
    }

    @Override
    public ArrayList<Scores> getScore(String sid) {
        return stuDao.getScoreBySid(sid);
    }
}
