package com.zhou.stusystem.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("courses")
public class Courses {
    @TableId
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
