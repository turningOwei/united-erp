package com.united.permission.service.impl;

import com.united.permission.dao.SysRoleResDao;
import com.united.permission.dao.entity.SysRoleRes;
import com.united.permission.service.SysRoleResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/9.
 */
@Service
public class SysRoleResServiceImpl implements SysRoleResService {
    @Autowired
    protected SysRoleResDao sysRoleResDao;
    @Override
    public List<SysRoleRes> getListByRole(Long roleId) {
        return sysRoleResDao.getList("roleId",roleId);
    }
}
