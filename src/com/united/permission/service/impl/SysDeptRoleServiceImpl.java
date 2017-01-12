package com.united.permission.service.impl;

import com.united.permission.dao.SysDeptRoleDao;
import com.united.permission.dao.entity.SysDeptRole;
import com.united.permission.domain.RoleEnum;
import com.united.permission.service.SysDeptRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by turningOwei on 2017/1/10.
 */
@Service
public class SysDeptRoleServiceImpl implements SysDeptRoleService {
    @Autowired
    private SysDeptRoleDao sysDeptRoleDao;
    @Override
    public List<SysDeptRole> listNotGeneralMager(Long deptId) {
        List<SysDeptRole> list = new ArrayList<SysDeptRole>();
        if(deptId !=null) {
            String hqlFormat = "deptId=%s and oid <>%s";
            String condition = String.format(hqlFormat,deptId,RoleEnum.GeneralManagerRole.getOid());
            list = sysDeptRoleDao.queryByHqlCondition(condition);
        }else{
            list = sysDeptRoleDao.getAll();
        }
        return list;
    }

    @Override
    public SysDeptRole getDeptSuperAdmin(Long deptId) {
        Map<String,Object>  map = new HashMap<>();
        map.put("deptId",deptId);
        map.put("isSuperAdmin",true);
        return  sysDeptRoleDao.getEquals(map);
    }
}
