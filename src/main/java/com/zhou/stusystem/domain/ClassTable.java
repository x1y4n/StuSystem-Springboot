package com.zhou.stusystem.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("classtable")
public class ClassTable {

  private String id;
  private String courseId;
  private String classId;
  private String tid;
  private String address;
  private int start;
  private int end;
  private int week;
}
