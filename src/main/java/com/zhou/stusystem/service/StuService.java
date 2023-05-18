package com.zhou.stusystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.stusystem.domain.Class;
import com.zhou.stusystem.domain.Courses;
import com.zhou.stusystem.domain.Scores;
import com.zhou.stusystem.domain.Students;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public interface  StuService extends IService<Students> {
    public Class getClass(String sid);

    public ArrayList<Courses> getCourse(String sid);

    public ArrayList<Scores> getScore(String sid);

}
