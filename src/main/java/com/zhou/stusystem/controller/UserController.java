package com.zhou.stusystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhou.stusystem.domain.user.AUser;
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
    SUserService sUserService;
    AUserService aUserService;

    @PostMapping("/teacher")
    public Result loginTuer(@RequestBody TUser tUser){
        System.out.println("***************************");
        System.out.println(tUser);
        System.out.println("***************************");
        LambdaQueryWrapper<TUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(TUser::getUsername, tUser.getUsername()).eq(TUser::getPassword, tUser.getPassword());
        TUser tUser1 = tUserService.getOne(lqw);
        return new Result(tUser1 !=null? Code.LOGIN_OK:Code.LOGIN_ERR, tUser1 !=null?"登陆成功":"登陆失败", tUser1);
    }

    @PostMapping("/admin")
    public Result loginAuser(@RequestBody AUser aUser){
        System.out.println("***************************");
        System.out.println(aUser);
        System.out.println("***************************");
        LambdaQueryWrapper<AUser> lqw = new LambdaQueryWrapper<>();
        lqw.eq(AUser::getUsername, aUser.getUsername()).eq(AUser::getPassword, aUser.getPassword());
        AUser aUser1 = aUserService.getOne(lqw);
        return new Result(aUser1 !=null? Code.LOGIN_OK:Code.LOGIN_ERR, aUser1 !=null?"登陆成功":"登陆失败", aUser1);
    }
    @GetMapping("/student/{id}")
    public Result StuLogin(@PathVariable Integer id){
        TUser tUser = tUserService.getById(id);
        return new Result(tUser !=null?Code.LOGIN_OK:Code.LOGIN_ERR, tUser !=null?"查询成功":"查询失败失败", tUser);
    }

}
