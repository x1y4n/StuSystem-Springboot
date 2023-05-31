package com.zhou.stusystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhou.stusystem.domain.*;
import com.zhou.stusystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/teacher")
@CrossOrigin

public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    // 根据tid查询老师信息
    @GetMapping("/{tid}")
    public Result getTeacher(@PathVariable String tid) {
        LambdaQueryWrapper<Teachers> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Teachers::getTid, tid);
        Teachers teachers = teacherService.getOne(lqw);
        return new Result(teachers != null ? Code.LOGIN_OK : Code.LOGIN_ERR, teachers != null ? "查询成功" : "查询失败失败", teachers);
    }

    // 根据tid查询老师所教课程信息
    @GetMapping("/courses/{tid}")
    public Result getClass(@PathVariable String tid) {
        ArrayList<Courses> arrayList = teacherService.getCourses(tid);
        return new Result(arrayList != null ? Code.LOGIN_OK : Code.LOGIN_ERR, arrayList != null ? "查询成功" : "查询失败失败", arrayList);
    }

    // 查询课程成绩信息
    @PostMapping("/courses/")
    public Result CourseGrade(@RequestBody Map<String, String> map) {
        System.out.println(map.get("tid"));
        ArrayList<CoursesGrade> arrayList = teacherService.getGrade(map.get("tid"), map.get("courseid"));
        return new Result(arrayList != null ? Code.LOGIN_OK : Code.LOGIN_ERR, arrayList != null ? "查询成功" : "查询失败失败", arrayList);
    }


    // 添加学生的课程成绩
    @PostMapping("/grade/")
    public Result AddGrade(@RequestBody Map<String, String> map) {
        int n = teacherService.addGrade(map.get("grade"), map.get("sid"), map.get("courseid"));
        return new Result(n > 0 ? Code.LOGIN_OK : Code.LOGIN_ERR, n != 0 ? "更新成功" : "更新失败", null);
    }

    // 修改学生的课程成绩
    @PutMapping("/grade/")
    public Result UpdateGrade(@RequestBody Map<String, String> map) {
        int n = teacherService.updateGrade(map.get("grade"), map.get("sid"), map.get("courseid"));
        return new Result(n > 0 ? Code.LOGIN_OK : Code.LOGIN_ERR, n != 0 ? "更新成功" : "更新失败", null);
    }


}
