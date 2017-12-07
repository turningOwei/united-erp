package com.united.system.service.impl;

import com.united.system.dao.SysCodeValueDao;
import com.united.system.dao.entity.SysCodeValue;
import com.united.system.service.SysCodeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 002465 on 2017/12/7.
 */
@Service
public class SysCodeValueServiceImpl implements SysCodeValueService {
    @Autowired
    private SysCodeValueDao sysCodeValueDao;
    @Override
    public void saveOrUpdate(SysCodeValue entity) {
        sysCodeValueDao.saveOrUpdate(entity);
    }
}
