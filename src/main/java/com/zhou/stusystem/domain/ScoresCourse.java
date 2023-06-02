package com.zhou.stusystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ScoresCourse {
    private String sid;
    private String courseid;
    private String grade;
    private String coursename;
    private Integer credit;

    public ScoresCourse(String sid, String courseid, String grade, String coursename) {
        this.sid = sid;
        this.courseid = courseid;
        this.grade = grade;
        this.coursename = coursename;
    }
}
