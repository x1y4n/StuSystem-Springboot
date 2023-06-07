package com.zhou.stusystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.stusystem.domain.entity.Scores;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScoresDao extends BaseMapper<Scores> {
}
