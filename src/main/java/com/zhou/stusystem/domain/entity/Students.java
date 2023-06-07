package com.zhou.stusystem.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("students")

public class Students {
    private String sid;
    private String sname;
    private String sgender;
    private String sbirthday;
    private String major;
    private String classid;
    private String saddress;
    private long sphone;

    public Students(String sid, String sname, String major, String classid) {
        this.sid = sid;
        this.sname = sname;
        this.major = major;
        this.classid = classid;
    }

    private String sremark;
}
