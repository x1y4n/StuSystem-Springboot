package com.zhou.stusystem;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.stusystem.dao.ClassDao;
import com.zhou.stusystem.dao.ScoresDao;
import com.zhou.stusystem.domain.Scores;
import com.zhou.stusystem.domain.ScoresCourse;
import com.zhou.stusystem.service.ClassService;
import com.zhou.stusystem.service.ScoresService;
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

    @Test
    void contextLoads() {
        IPage<Scores> page = new Page<>(1,5);
        scoresDao.selectPage(page,null);
    }

}
