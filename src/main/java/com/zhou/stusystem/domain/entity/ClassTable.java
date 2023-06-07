package com.zhou.stusystem.domain.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("classtable")
public class ClassTable {

    private String courseid;
    private String classid;
    private String address;
    private int start;
    private int end;
    private int week;
    /**
     * 课表中没有这个字段，所以这里要用，TableFiled标识字段，不然要报错
     */
    @TableField(exist = false)
    private String coursename;
    @TableField(exist = false)
    private String tid;
    @TableField(exist = false)
    private String tname;
}
