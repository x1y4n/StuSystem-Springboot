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
    public Result loginStudent(@RequestBody SUser sUser){
        System.out.println("***************************");
        System.out.println(sUser);
        System.out.println("***************************");
        LambdaQueryWrapper<SUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SUser::getUsername, sUser.getUsername()).eq(SUser::getPassword, sUser.getPassword());
        SUser sUser1 = sUserService.getOne(lqw);
        return new Result(sUser1 !=null? Code.LOGIN_OK:Code.LOGIN_ERR, sUser1 !=null?"登陆成功":"登陆失败", sUser1);
    }
    @PostMapping("/teacher") // 老师登陆
    public Result loginTeacher(@RequestBody TUser tUser){
        System.out.println("***************************");
        System.out.println(tUser);
        System.out.println("***************************");
        LambdaQueryWrapper<TUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(TUser::getUsername, tUser.getUsername()).eq(TUser::getPassword, tUser.getPassword());
        TUser tUser1 = tUserService.getOne(lqw);
        return new Result(tUser1 !=null? Code.LOGIN_OK:Code.LOGIN_ERR, tUser1 !=null?"登陆成功":"登陆失败", tUser1);
    }
    @PostMapping("/admin") // 管理员登陆
    public Result loginAdmin(@RequestBody AUser aUser){
        System.out.println("***************************");
        System.out.println(aUser);
        System.out.println("***************************");
        LambdaQueryWrapper<AUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(AUser::getUsername, aUser.getUsername()).eq(AUser::getPassword, aUser.getPassword());
        AUser aUser1 = aUserService.getOne(lqw);
        return new Result(aUser1 !=null? Code.LOGIN_OK:Code.LOGIN_ERR, aUser1 !=null?"登陆成功":"登陆失败", aUser1);
    }
    @GetMapping("/student/{id}") // 根据sid查询学生信息
    public Result getSid(@PathVariable Integer id){
        SUser sUser = sUserService.getById(id);
        return new Result(sUser !=null?Code.LOGIN_OK:Code.LOGIN_ERR, sUser !=null?"查询成功":"查询失败失败", sUser);
    }
    @GetMapping("/teacher/{id}") // 根据tid查询老师信息
    public Result getTid(@PathVariable Integer id){
        TUser tUser = tUserService.getById(id);
        return new Result(tUser !=null?Code.LOGIN_OK:Code.LOGIN_ERR, tUser !=null?"查询成功":"查询失败失败", tUser);
    }

}
