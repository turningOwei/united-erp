package com.united.permission.service;

import com.united.permission.dao.entity.SysResource;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/16.
 */
public interface RoleResServie {
    /**
     * 通过公司、角色获取 本角色资源菜单
     * @param corpId
     * @param roleId
     * @return
     */
    public List<SysResource> getSysResouceByCorpAndRole(Long corpId,Long roleId);

    public void saveRoleResource(Long corpId, Long roleId, Long[] resourceIds);
}
