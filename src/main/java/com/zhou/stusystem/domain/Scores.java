package com.zhou.stusystem.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("scores")
public class Scores {
    private String sid;
    private String courseid;
    private Integer grade;
}
