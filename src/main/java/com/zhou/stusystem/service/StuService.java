package com.zhou.stusystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.stusystem.domain.entity.Class;
import com.zhou.stusystem.domain.entity.Courses;
import com.zhou.stusystem.domain.ScoresCourse;
import com.zhou.stusystem.domain.entity.Students;

import java.util.ArrayList;

public interface  StuService extends IService<Students> {
    public Class getClass(String sid);

    public ArrayList<Courses> getCourse(String sid);

    public ArrayList<ScoresCourse> getScore(String sid);

    public ArrayList<ScoresCourse> getAllScores();

    public ArrayList<ScoresCourse> searchScores(String query);


}
