package com.united.corp.service.impl;

import com.united.corp.dao.SysDepartmentDao;
import com.united.corp.dao.entity.SysDepartment;
import com.united.corp.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/9.
 */
@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {
    @Autowired
    private SysDepartmentDao sysDepartmentDao;
    @Override
    public List<SysDepartment> listAll() {
        return sysDepartmentDao.list();
    }
}
