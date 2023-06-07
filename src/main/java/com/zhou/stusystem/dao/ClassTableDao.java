package com.zhou.stusystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.stusystem.domain.Table;
import com.zhou.stusystem.domain.entity.ClassTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassTableDao extends BaseMapper<ClassTable> {
    @Select("SELECT courses.courseid,courseName,classId,\n" +
            "       courses.tid,tname,address,start,end,week\n" +
            "FROM classtable,\n" +
            "     courses,\n" +
            "     teachers\n" +
            "where courses.courseId = classtable.courseId\n" +
            "  and courses.tid = teachers.tid")
    public List<ClassTable>getClassTable();

    @Select("SELECT courses.courseid,courseName,classId,\n" +
            "       courses.tid,tname,address,start,end,week\n" +
            "FROM classtable,\n" +
            "     courses,\n" +
            "     teachers\n" +
            "where courses.courseId = classtable.courseId\n" +
            "  and courses.tid = teachers.tid ${query}")
    public List<ClassTable> searchClassTable(String query);

    @Select("SELECT courses.courseid,\n" +
            "       courseName,\n" +
            "       classId,\n" +
            "       courses.tid,\n" +
            "       address,\n" +
            "       start,\n" +
            "       end,\n" +
            "       week\n" +
            "FROM classtable,\n" +
            "     courses,\n" +
            "     teachers\n" +
            "where courses.courseId = classtable.courseId\n" +
            "  and courses.tid = teachers.tid")
    public List<Table> searchTable();
}
