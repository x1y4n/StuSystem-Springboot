package com.zhou.stusystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.stusystem.dao.CoursesDao;
import com.zhou.stusystem.domain.entity.Courses;
import com.zhou.stusystem.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends ServiceImpl<CoursesDao, Courses> implements CourseService {

}
