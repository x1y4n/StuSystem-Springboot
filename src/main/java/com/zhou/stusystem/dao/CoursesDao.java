package com.zhou.stusystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.stusystem.domain.Class;
import com.zhou.stusystem.domain.Courses;
import com.zhou.stusystem.domain.ScoresCourse;
import com.zhou.stusystem.domain.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface CoursesDao extends BaseMapper<Courses> {
}
