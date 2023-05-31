package com.zhou.stusystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.stusystem.domain.Courses;
import com.zhou.stusystem.domain.CoursesGrade;
import com.zhou.stusystem.domain.Teachers;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

@Mapper
public interface TeacherDao extends BaseMapper<Teachers> {

    @Select("select * from courses where tid=#{tid}")
    public ArrayList<Courses> getCoursesByTid(String tid);

    @Select("select scores.courseId,courseName, students.sid,sname,grade from scores,courses,students\n" +
            "         where scores.courseId = courses.courseId and scores.sid=students.sid\n" +
            "            and scores.courseId = #{courseid} and tid= #{tid} ")
    public ArrayList<CoursesGrade> getCoursesGrade(String tid, String courseid);

    @Update("update scores set grade = #{grade} where sid=#{sid} and courseId = #{courseid}")
    public int updateGrade(String grade,String sid, String courseid);

    @Insert("insert into scores (sid, courseId, grade) values (#{sid},#{courseid},#{grade})")
    public int addGrade(String grade,String sid, String courseid);

}
