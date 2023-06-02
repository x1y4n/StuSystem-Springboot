package com.zhou.stusystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhou.stusystem.domain.Class;
import com.zhou.stusystem.domain.Courses;
import com.zhou.stusystem.domain.ScoresCourse;
import com.zhou.stusystem.domain.Students;
import com.zhou.stusystem.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/stu")
@CrossOrigin

public class StuController {
    @Autowired
    private StuService Stuservice;

    @GetMapping("/{sid}")
    public Result getStu(@PathVariable String sid){
        LambdaQueryWrapper<Students> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Students::getSid,sid);
        Students students = Stuservice.getOne(lqw);
        return new Result(students !=null?Code.LOGIN_OK:Code.LOGIN_ERR, students !=null?"查询成功":"查询失败失败", students);
    }

    @GetMapping("/class/{sid}")
    public Result getClass(@PathVariable String sid){
        System.out.println("********************");
        System.out.println(sid);
        System.out.println("********************");
        Class aClass = Stuservice.getClass(sid);
        return new Result(aClass !=null?Code.LOGIN_OK:Code.LOGIN_ERR, aClass !=null?"查询成功":"查询失败失败", aClass);
    }
    @GetMapping("/course/{sid}")
    public Result getCourse(@PathVariable String sid){
        System.out.println("********************");
        System.out.println(sid);
        System.out.println("********************");
        ArrayList<Courses> arrayList = new ArrayList<>();
        arrayList = Stuservice.getCourse(sid);
        return new Result(arrayList !=null?Code.LOGIN_OK:Code.LOGIN_ERR, arrayList !=null?"查询成功":"查询失败失败", arrayList);
    }

    @GetMapping("/score/{sid}")
    public Result getScore(@PathVariable String sid){
        ArrayList<ScoresCourse> arrayList = new ArrayList<>();
        arrayList = Stuservice.getScore(sid);
        return new Result(arrayList !=null?Code.LOGIN_OK:Code.LOGIN_ERR, arrayList !=null?"查询成功":"查询失败失败", arrayList);
    }
}
