package com.zhou.stusystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursesGrade {
    private String courseid;
    private String coursename;
    private String sid;
    private String sname;
    private Integer grade;
}
