package com.zhou.stusystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhou.stusystem.domain.User;
import com.zhou.stusystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public Result login(@RequestBody User user){
        System.out.println("***************************");
        System.out.println(user);
        System.out.println("***************************");
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername,user.getUsername()).eq(User::getPassword,user.getPassword());
        User user1 = userService.getOne(lqw);
        return new Result(user1!=null? Code.LOGIN_OK:Code.LOGIN_ERR,user1!=null?"登陆成功":"登陆失败", user1);
    }
    @GetMapping("/{id}")
    public Result GetUserById(@PathVariable Integer id){
        User user = userService.getById(id);
        return new Result(user!=null?Code.LOGIN_OK:Code.LOGIN_ERR,user!=null?"查询成功":"查询失败失败", user);
    }

}
