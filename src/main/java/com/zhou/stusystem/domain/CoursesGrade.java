package com.zhou.stusystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CoursesGrade {
    private String courseid;
    private String coursename;
    private String sid;
    private String sname;
    private Integer grade;
}
