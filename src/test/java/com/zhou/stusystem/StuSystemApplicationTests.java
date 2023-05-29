package com.zhou.stusystem;

import com.zhou.stusystem.service.user.TUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StuSystemApplicationTests {

    @Autowired
    TUserService tUserService;
    @Test
    void contextLoads() {
        tUserService.getById("0203017513");
    }

}
