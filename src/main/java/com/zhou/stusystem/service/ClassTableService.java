package com.zhou.stusystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.stusystem.domain.Table;
import com.zhou.stusystem.domain.entity.ClassTable;

import java.util.List;

public interface ClassTableService extends IService<ClassTable> {
    public List<ClassTable>getClassTable();

    public List<ClassTable> searchClassTable(String query);

    public List<Table> searchTable();

}
