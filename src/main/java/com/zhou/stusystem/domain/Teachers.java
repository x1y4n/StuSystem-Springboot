package com.zhou.stusystem.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("teachers")
public class Teachers {

    private String tid;
    private String tname;
    private String tgender;
    private String tbirthday;
    private String tdept;
    private long tphone;

}
