package com.zhou.stusystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Courses {
    private String courseid;
    private String tid;
    private String coursename;
    private Integer credit;
    private Integer xs;
}
