package com.united.permission.service;

import com.united.permission.dao.entity.SysResource;
import com.united.permission.dao.entity.SysRoleRes;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/9.
 */
public interface SysRoleResService {
    public List<SysRoleRes> getListByRole(Long roleId);

    public void saveRoleResource(Long roleId, Long[] resourceIds);
}
