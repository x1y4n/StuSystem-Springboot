package com.zhou.stusystem.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.stusystem.domain.user.SUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SUserDao extends BaseMapper<SUser> {
}
