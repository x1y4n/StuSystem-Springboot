package com.zhou.stusystem.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Scores {
    private String sid;
    private String courseid;
    private String grade;
    private String coursename;
    private Integer credit;

    public Scores(String courseid, String grade, String coursename, Integer credit) {
        this.courseid = courseid;
        this.grade = grade;
        this.coursename = coursename;
        this.credit = credit;
    }
}
