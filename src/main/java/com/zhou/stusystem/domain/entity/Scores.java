package com.zhou.stusystem.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("scores")
public class Scores {
    private String sid;
    private String courseid;
    private Integer grade;
}
