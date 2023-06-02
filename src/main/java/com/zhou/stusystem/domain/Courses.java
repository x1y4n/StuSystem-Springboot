package com.zhou.stusystem.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("courses")
public class Courses {
    private String courseid;
    private String tid;
    private String coursename;
    private Integer credit;
    private Integer xs;

    public Courses(String courseid, String coursename) {
        this.courseid = courseid;
        this.coursename = coursename;
    }
}
