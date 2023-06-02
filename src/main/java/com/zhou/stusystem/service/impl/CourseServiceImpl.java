package com.zhou.stusystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.stusystem.dao.ClassDao;
import com.zhou.stusystem.dao.CoursesDao;
import com.zhou.stusystem.domain.Class;
import com.zhou.stusystem.domain.Courses;
import com.zhou.stusystem.service.ClassService;
import com.zhou.stusystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends ServiceImpl<CoursesDao, Courses> implements CourseService {

}
