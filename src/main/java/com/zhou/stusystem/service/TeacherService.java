package com.zhou.stusystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.stusystem.domain.Courses;
import com.zhou.stusystem.domain.CoursesGrade;
import com.zhou.stusystem.domain.Teachers;

import java.util.ArrayList;

public interface TeacherService extends IService<Teachers> {
    public ArrayList<Courses> getCourses(String tid);

    public ArrayList<CoursesGrade> getGrade(String tid, String courseid);

    public int updateGrade(String grade,String sid, String courseid);

    public int addGrade(String grade,String sid, String courseid);
}
