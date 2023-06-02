package com.zhou.stusystem.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("class")
public class Class {
    private String classid;
    private String major;
    private int num;
    private String classtime;
    private String fdy;

    public Class(String classid, String major, String classTime) {
        this.classid = classid;
        this.major = major;
        this.classtime = classTime;
    }
}
