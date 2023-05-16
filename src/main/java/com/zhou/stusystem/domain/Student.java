package com.zhou.stusystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
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
