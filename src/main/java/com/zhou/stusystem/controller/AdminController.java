package com.zhou.stusystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhou.stusystem.domain.Class;
import com.zhou.stusystem.domain.*;
import com.zhou.stusystem.service.ClassService;
import com.zhou.stusystem.service.CourseService;
import com.zhou.stusystem.service.ScoresService;
import com.zhou.stusystem.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    StuService stuService;
    @Autowired
    ClassService classService;
    @Autowired
    ScoresService scoresService;
    @Autowired
    CourseService courseService;

    //查询所有学生信息
    @GetMapping("/student")
    public Result getStudent() {
        List<Students> list = new ArrayList<>();
        list = stuService.list();
        return new Result(list != null ? Code.LOGIN_OK : Code.LOGIN_ERR, list != null ? "查询成功" : "查询失败", list);
    }

    //按条件查询学生信息
    @PostMapping("/student/query")
    public Result searchStudent(@RequestBody Students students) {
        LambdaQueryWrapper<Students> lqw = new LambdaQueryWrapper<>();
        System.out.println("******************************");
        System.out.println(students.getSid());
        if (!students.getSid().equals(""))
            lqw.eq(Students::getSid, students.getSid());
        if (!students.getSname().equals(""))
            lqw.eq(Students::getSname, students.getSname());
        if (!students.getClassid().equals(""))
            lqw.eq(Students::getClassid, students.getClassid());
        if (!students.getMajor().equals(""))
            lqw.eq(Students::getMajor, students.getMajor());
        List<Students> list = new ArrayList<>();
        list = stuService.list(lqw);
        return new Result(list != null ? Code.LOGIN_OK : Code.LOGIN_ERR, list != null ? "查询成功" : "查询失败", list);
    }

    //添加学生信息
    @PostMapping("/student")
    public Result addStudent(@RequestBody Students students) {
        boolean n = stuService.save(students);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "添加成功" : "添加失败", null);
    }

    //更新学生信息
    @PutMapping("/student")
    public Result updateStudent(@RequestBody Students students) {
        LambdaQueryWrapper<Students> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Students::getSid, students.getSid());
        boolean n = stuService.update(students, lqw);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "更新成功" : "更新失败", null);
    }

    //删除学生信息
    @DeleteMapping("/student/")
    public Result deletestudent(@RequestBody Map<String, Object> map) {
        Boolean n = stuService.removeByMap(map);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "删除成功" : "删除失败", null);
    }

    //查询所有成绩
    @GetMapping("/student/scores")
    public Result getScorce() {
        ArrayList<ScoresCourse> list = new ArrayList<>();
        list = stuService.getAllScores();
        return new Result(list != null ? Code.LOGIN_OK : Code.LOGIN_ERR, list != null ? "查询成功" : "查询失败", list);
    }

    //根据条件查询成绩
    @PostMapping("/student/scores/query")
    public Result searchScore(@RequestBody Map<String, Object> map) {
        String query = "";
        if (!map.get("sid").equals(""))
            query += " and sid= " + map.get("sid");
        if (!map.get("courseid").equals(""))
            query += " and scores.courseId= " + map.get("courseid");
        if (!map.get("low").equals(""))
            query += " and grade >= " + map.get("low");
        if (!map.get("height").equals(""))
            query += " and grade <= " + map.get("height");
        System.out.println(query);
        ArrayList<ScoresCourse> list = new ArrayList<>();
        list = stuService.searchScores(query);
        return new Result(list != null ? Code.LOGIN_OK : Code.LOGIN_ERR, list != null ? "查询成功" : "查询失败", list);
    }

    //添加成绩
    @PostMapping("/student/scores")
    public Result addScores(@RequestBody Scores scores) {
        boolean n = scoresService.save(scores);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "添加成功" : "添加失败", null);
    }

    //更新成绩信息
    @PutMapping("/student/scores")
    public Result updateScores(@RequestBody Scores scores) {
        LambdaQueryWrapper<Scores> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Scores::getSid, scores.getSid());
        boolean n = scoresService.update(scores, lqw);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "更新成功" : "更新失败", null);
    }

    //删除成绩信息
    @DeleteMapping("/student/scores/")
    public Result deletescores(@RequestBody Map<String, Object> map) {
        Boolean n = scoresService.removeByMap(map);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "删除成功" : "删除失败", null);
    }

    //查询所有课程id
    @GetMapping("/student/courseid")
    public Result getCourseId() {
        LambdaQueryWrapper<Courses> lqw = new LambdaQueryWrapper<>();
        lqw.select(Courses::getCourseid);
        List<Map<String, Object>> maps;
        maps = courseService.listMaps(lqw);
        return new Result(maps != null ? Code.LOGIN_OK : Code.LOGIN_ERR, maps != null ? "查询成功" : "查询失败", maps);
    }

    //查询班级id和专业
    @GetMapping("/classid")
    public Result GetClassId() {
        LambdaQueryWrapper<Class> lqw = new LambdaQueryWrapper<>();
        lqw.select(Class::getClassid, Class::getMajor);
        List<Map<String, Object>> maps;
        maps = classService.listMaps(lqw);
        return new Result(maps != null ? Code.LOGIN_OK : Code.LOGIN_ERR, maps != null ? "查询成功" : "查询失败", maps);
    }

    //查询所有班级信息
    @GetMapping("/class")
    public Result getAllClass() {
        List<Class> list = new ArrayList<>();
        list = classService.list();
        return new Result(list != null ? Code.LOGIN_OK : Code.LOGIN_ERR, list != null ? "查询成功" : "查询失败", list);
    }

    //新增班级信息
    @PostMapping("/class")
    public Result addClass(@RequestBody Class aclass) {
        Boolean n = classService.save(aclass);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "添加成功" : "添加失败", null);
    }

    //更新班级信息
    @PutMapping("/class")
    public Result updateClass(@RequestBody Class aclass) {
        LambdaQueryWrapper<Class> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Class::getClassid, aclass.getClassid());
        Boolean n = classService.update(aclass, lqw);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "更新成功" : "更新失败", null);
    }

    //删除班级
    @DeleteMapping("/class/")
    public Result deleteClass(@RequestBody Map<String, Object> map) {
        Boolean n = classService.removeByMap(map);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "删除成功" : "删除失败", null);
    }

    //按条件查询班级信息
    @PostMapping("/class/query")
    public Result searchClass(@RequestBody Class aclass) {
        LambdaQueryWrapper<Class> lqw = new LambdaQueryWrapper<>();
        if (!aclass.getClassid().equals(""))
            lqw.eq(Class::getClassid, aclass.getClassid());
        if (!aclass.getMajor().equals(""))
            lqw.eq(Class::getMajor, aclass.getMajor());
        if (!aclass.getClasstime().equals(""))
            lqw.eq(Class::getClasstime, aclass.getClasstime());
        List<Class> list = new ArrayList<>();
        list = classService.list(lqw);
        return new Result(list != null ? Code.LOGIN_OK : Code.LOGIN_ERR, list != null ? "查询成功" : "查询失败", list);
    }


}
