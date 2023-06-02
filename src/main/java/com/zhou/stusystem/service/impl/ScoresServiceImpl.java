package com.zhou.stusystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.stusystem.dao.ClassDao;
import com.zhou.stusystem.dao.ScoresDao;
import com.zhou.stusystem.domain.Class;
import com.zhou.stusystem.domain.Scores;
import com.zhou.stusystem.service.ClassService;
import com.zhou.stusystem.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoresServiceImpl extends ServiceImpl<ScoresDao, Scores> implements ScoresService {

}
