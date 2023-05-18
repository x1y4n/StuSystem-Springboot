package com.zhou.stusystem.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("students")

public class Students {
    private String sid;
    private String sname;
    private String sgender;
    private String sbirthday;
    private String major;
    private String classid;
    private String saddress;
    private Integer sphone;
    private String sremark;
}
