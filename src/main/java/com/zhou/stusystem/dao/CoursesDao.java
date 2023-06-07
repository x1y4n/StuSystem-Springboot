package com.zhou.stusystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.stusystem.domain.entity.Courses;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CoursesDao extends BaseMapper<Courses> {
}
