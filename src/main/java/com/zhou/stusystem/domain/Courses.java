package com.zhou.stusystem.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("courses")
public class Courses {
    private String courseid;
    private String coursename;
    private Integer credit;
    private Integer xs;
}
