package com.zhou.stusystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.stusystem.dao.ClassTableDao;
import com.zhou.stusystem.domain.Table;
import com.zhou.stusystem.domain.entity.ClassTable;
import com.zhou.stusystem.service.ClassTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTableServiceImpl extends ServiceImpl<ClassTableDao, ClassTable> implements ClassTableService {
    @Autowired
    ClassTableDao classTableDao;

    public List<ClassTable> getClassTable() {
        return classTableDao.getClassTable();
    }

    public List<ClassTable> searchClassTable(String query) {
        return classTableDao.searchClassTable(query);
    }

    @Override
    public List<Table> searchTable() {
        return classTableDao.searchTable();
    }
}
