package com.united.permission.service;

import com.united.permission.dao.entity.SysDeptRole;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/10.
 */
public interface SysDeptRoleService {
    List<SysDeptRole> listNotGeneralMager(Long deptId);

    public SysDeptRole getDeptSuperAdmin(Long deptId);

    List<SysDeptRole> getAll();

    List<SysDeptRole> listNormalRoleByDept(Long deptId);

    List<SysDeptRole> listAll();
}
