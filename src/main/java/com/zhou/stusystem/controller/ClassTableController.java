package com.zhou.stusystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhou.stusystem.domain.Table;
import com.zhou.stusystem.domain.entity.ClassTable;
import com.zhou.stusystem.domain.entity.Courses;
import com.zhou.stusystem.service.ClassService;
import com.zhou.stusystem.service.ClassTableService;
import com.zhou.stusystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/classtable")
@CrossOrigin
public class ClassTableController {
    @Autowired
    ClassService classService;
    @Autowired
    ClassTableService cTService;

    @Autowired
    CourseService courseService;

    //查询所有课程表信息
    @GetMapping
    public Result getTable() {
        List<ClassTable> list = new ArrayList<>();
        list = cTService.getClassTable();
        return new Result(list != null ? Code.LOGIN_OK : Code.LOGIN_ERR, list != null ? "查询成功" : "查询失败", list);
    }

    //根据条件查询课程表信息
    @PostMapping("/query")
    public Result findTable(@RequestBody ClassTable classTable) {
        String query = "";
        if (!classTable.getCourseid().equals(""))
            query += " and courses.courseid = " + classTable.getCourseid();
        if (!classTable.getCoursename().equals(""))
            query += " and coursename like '%" + classTable.getCoursename() + "%'";
        if (!classTable.getTid().equals(""))
            query += " and courses.tid = " + classTable.getTid();
        if (classTable.getWeek() > 0 && classTable.getWeek() < 8)
            query += " and week = " + classTable.getWeek();
        System.out.println("********************");
        System.out.println(query);
        List<ClassTable> list = new ArrayList<>();
        list = cTService.searchClassTable(query);
        return new Result(list != null ? Code.LOGIN_OK : Code.LOGIN_ERR, list != null ? "查询成功" : "查询失败", list);
    }

    //更新课程表信息
    @PutMapping()
    public Result updateTable(@RequestBody ClassTable classTable) {
        LambdaQueryWrapper<ClassTable> lqw = new LambdaQueryWrapper<>();
        lqw.eq(ClassTable::getCourseid, classTable.getCourseid());
        Boolean n = cTService.update(classTable, lqw);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "更新成功" : "更新失败", null);
    }

    //删除班级
    @DeleteMapping()
    public Result deleteTable(@RequestBody Map<String, Object> map) {
        Boolean n = cTService.removeByMap(map);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "删除成功" : "删除失败", null);
    }

    //根据课程id查询课程名字
    @GetMapping("course/{id}")
    public Result getCourseName(@PathVariable String id) {
        LambdaQueryWrapper<Courses> lqw = new LambdaQueryWrapper<>();
        lqw.select(Courses::getCoursename).eq(Courses::getCourseid, id);
        Courses courses = courseService.getOne(lqw);
        return new Result(courses != null ? Code.LOGIN_OK : Code.LOGIN_ERR, courses != null ? "查询成功" : "查询失败", courses);
    }

    //添加课程表信息
    @PostMapping()
    public Result addTable(@RequestBody ClassTable classTable) {
        Boolean n = cTService.save(classTable);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "添加成功" : "添加失败", null);
    }

    @GetMapping("/table")
    public Result searchTable(){
        List<Table>list = cTService.searchTable();
        return new Result(list != null ? Code.LOGIN_OK : Code.LOGIN_ERR, list != null ? "查询成功" : "查询失败", list);
    }



}
