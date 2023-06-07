package com.zhou.stusystem;

import com.zhou.stusystem.dao.ClassDao;
import com.zhou.stusystem.dao.ClassTableDao;
import com.zhou.stusystem.dao.ScoresDao;
import com.zhou.stusystem.service.ClassService;
import com.zhou.stusystem.service.ClassTableService;
import com.zhou.stusystem.service.StuService;
import com.zhou.stusystem.service.user.TUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StuSystemApplicationTests {

    @Autowired
    TUserService tUserService;

    @Autowired
    StuService stuService;

    @Autowired
    ClassService classService;

    @Autowired
    ClassDao classDao;
    @Autowired
    ScoresDao scoresDao;

    @Autowired
    ClassTableService classTableService;
    @Autowired
    ClassTableDao classTableDao;

    @Test
    void contextLoads() {
        System.out.println(classTableDao.searchClassTable("and courses.courseid = '001'"));
    }

}
