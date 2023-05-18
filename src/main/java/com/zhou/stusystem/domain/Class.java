package com.zhou.stusystem.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("class")
public class Class {
    private String classid;
    private String major;
    private int num;
    private int classTime;
    private String fdy;
}
