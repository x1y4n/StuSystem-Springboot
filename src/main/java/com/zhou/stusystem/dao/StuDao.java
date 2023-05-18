package com.zhou.stusystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.stusystem.domain.Class;
import com.zhou.stusystem.domain.Courses;
import com.zhou.stusystem.domain.Scores;
import com.zhou.stusystem.domain.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface StuDao extends BaseMapper<Students> {
    @Select("select * FROM class where classid = (select classId FROM students where sid = #{sid})")
    public Class getClassBySid(String sid);

    @Select("SELECT * from courses,scores  where courses.courseId=scores.courseId AND sid=#{sid}")
    public ArrayList<Courses> getCourseBySid(String sid);

    @Select("SELECT scores.courseId,credit,courseName, grade FROM scores,courses WHERE scores.courseId = courses.courseId and scores.sid =#{sid}")
    public ArrayList<Scores> getScoreBySid(String sid);
}
