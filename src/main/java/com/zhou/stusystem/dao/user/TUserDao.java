package com.zhou.stusystem.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.stusystem.domain.entity.user.TUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TUserDao extends BaseMapper<TUser> {
}
