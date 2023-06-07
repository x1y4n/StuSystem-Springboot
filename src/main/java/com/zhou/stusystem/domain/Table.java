package com.zhou.stusystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table {
    private String coursename;
    private String classid;
    private String address;
    private int start;
    private int end;
    private int week;
}
