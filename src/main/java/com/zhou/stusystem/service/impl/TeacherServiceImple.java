package com.zhou.stusystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.stusystem.dao.TeacherDao;
import com.zhou.stusystem.domain.Courses;
import com.zhou.stusystem.domain.CoursesGrade;
import com.zhou.stusystem.domain.Teachers;
import com.zhou.stusystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherServiceImple extends ServiceImpl<TeacherDao, Teachers> implements TeacherService {
    @Autowired
    TeacherDao teacherDao;

    @Override
    public ArrayList<Courses> getCourses(String tid) {
        return teacherDao.getCoursesByTid(tid);
    }

    @Override
    public ArrayList<CoursesGrade> getGrade(String tid, String courseid) {
        return teacherDao.getCoursesGrade(tid, courseid);
    }

    @Override
    public int updateGrade(String grade, String sid, String courseid) {
        return teacherDao.updateGrade(grade, sid, courseid);
    }

    @Override
    public int addGrade(String grade, String sid, String courseid) {
        return teacherDao.addGrade(grade, sid, courseid);
    }

}
