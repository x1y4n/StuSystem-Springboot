package com.zhou.stusystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhou.stusystem.domain.user.AUser;
import com.zhou.stusystem.domain.user.SUser;
import com.zhou.stusystem.domain.user.TUser;
import com.zhou.stusystem.service.user.AUserService;
import com.zhou.stusystem.service.user.SUserService;
import com.zhou.stusystem.service.user.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    TUserService tUserService;
    @Autowired
    SUserService sUserService;
    @Autowired
    AUserService aUserService;


    @PostMapping("/student") // 学生登陆
    public Result loginStudent(@RequestBody SUser sUser) {
        LambdaQueryWrapper<SUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SUser::getUsername, sUser.getUsername()).eq(SUser::getPassword, sUser.getPassword());
        SUser sUser1 = sUserService.getOne(lqw);
        return new Result(sUser1 != null ? Code.LOGIN_OK : Code.LOGIN_ERR, sUser1 != null ? "登陆成功" : "登陆失败", sUser1);
    }

    @PostMapping("/teacher") // 老师登陆
    public Result loginTeacher(@RequestBody TUser tUser) {
        LambdaQueryWrapper<TUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(TUser::getUsername, tUser.getUsername()).eq(TUser::getPassword, tUser.getPassword());
        TUser tUser1 = tUserService.getOne(lqw);
        return new Result(tUser1 != null ? Code.LOGIN_OK : Code.LOGIN_ERR, tUser1 != null ? "登陆成功" : "登陆失败", tUser1);
    }

    @PostMapping("/admin") // 管理员登陆
    public Result loginAdmin(@RequestBody AUser aUser) {
        LambdaQueryWrapper<AUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(AUser::getUsername, aUser.getUsername()).eq(AUser::getPassword, aUser.getPassword());
        AUser aUser1 = aUserService.getOne(lqw);
        return new Result(aUser1 != null ? Code.LOGIN_OK : Code.LOGIN_ERR, aUser1 != null ? "登陆成功" : "登陆失败", aUser1);
    }

    @GetMapping("/student/{id}") // 根据sid查询学生信息
    public Result getSid(@PathVariable Integer id) {
        SUser sUser = sUserService.getById(id);
        return new Result(sUser != null ? Code.LOGIN_OK : Code.LOGIN_ERR, sUser != null ? "查询成功" : "查询失败失败", sUser);
    }

    @GetMapping("/teacher/{id}") // 根据tid查询老师信息
    public Result getTid(@PathVariable Integer id) {
        TUser tUser = tUserService.getById(id);
        return new Result(tUser != null ? Code.LOGIN_OK : Code.LOGIN_ERR, tUser != null ? "查询成功" : "查询失败失败", tUser);
    }


    //管理员用户
    @GetMapping("/auser")
    public Result getAUser() {
        List<AUser> list = new ArrayList<>();
        list = aUserService.list();
        return new Result(list != null ? Code.LOGIN_OK : Code.LOGIN_ERR, list != null ? "查询成功" : "查询失败", list);
    }

    @PutMapping("/auser")
    public Result updateAUser(@RequestBody AUser aUser) {
        LambdaQueryWrapper<AUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(AUser::getId, aUser.getId());
        Boolean n = aUserService.update(aUser, lqw);
        return new Result(n != null ? Code.LOGIN_OK : Code.LOGIN_ERR, n != null ? "更新成功" : "更新失败", null);
    }

    @PostMapping("/auser")
    public Result inserAUser(@RequestBody AUser aUser) {
        Boolean n = aUserService.save(aUser);
        return new Result(n != null ? Code.LOGIN_OK : Code.LOGIN_ERR, n != null ? "添加成功" : "添加失败", null);
    }

    @DeleteMapping("/auser/")
    public Result deleteAUser(@RequestBody Map<String, Object> map) {
        Boolean n = aUserService.removeByMap(map);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "删除成功" : "删除失败", null);
    }


    //学生用户
    @GetMapping("/suser")
    public Result getSUser() {
        List<SUser> list = new ArrayList<>();
        list = sUserService.list();
        return new Result(list != null ? Code.LOGIN_OK : Code.LOGIN_ERR, list != null ? "查询成功" : "查询失败", list);
    }

    @PutMapping("/suser")
    public Result updateSUser(@RequestBody SUser sUser) {
        LambdaQueryWrapper<SUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SUser::getSid, sUser.getSid());
        Boolean n = sUserService.update(sUser, lqw);
        return new Result(n != null ? Code.LOGIN_OK : Code.LOGIN_ERR, n != null ? "更新成功" : "更新失败", null);
    }

    @PostMapping("/suser")
    public Result inserSUser(@RequestBody SUser sUser) {
        Boolean n = sUserService.save(sUser);
        return new Result(n != null ? Code.LOGIN_OK : Code.LOGIN_ERR, n != null ? "添加成功" : "添加失败", null);
    }

    @DeleteMapping("/suser/")
    public Result deleteSUser(@RequestBody Map<String, Object> map) {
        Boolean n = sUserService.removeByMap(map);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "删除成功" : "删除失败", null);
    }

    //教师用户
    @GetMapping("/tuser")
    public Result getTUser() {
        List<TUser> list = new ArrayList<>();
        list = tUserService.list();
        return new Result(list != null ? Code.LOGIN_OK : Code.LOGIN_ERR, list != null ? "查询成功" : "查询失败", list);
    }

    @PutMapping("/tuser")
    public Result updateSUser(@RequestBody TUser tUser) {
        LambdaQueryWrapper<TUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(TUser::getTid, tUser.getTid());
        Boolean n = tUserService.update(tUser, lqw);
        return new Result(n != null ? Code.LOGIN_OK : Code.LOGIN_ERR, n != null ? "更新成功" : "更新失败", null);
    }

    @PostMapping("/tuser")
    public Result inserTUser(@RequestBody TUser tUser) {
        Boolean n = tUserService.save(tUser);
        return new Result(n != null ? Code.LOGIN_OK : Code.LOGIN_ERR, n != null ? "添加成功" : "添加失败", null);
    }

    @DeleteMapping("/tuser/")
    public Result deleteTUser(@RequestBody Map<String, Object> map) {
        Boolean n = tUserService.removeByMap(map);
        return new Result(n ? Code.LOGIN_OK : Code.LOGIN_ERR, n ? "删除成功" : "删除失败", null);
    }


}
